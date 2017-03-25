package totoBook.controller.question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/detail.do")
public class QuestionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		HttpSession session = request.getSession();

		QuestionService service = new QuestionServiceLogic();
		post = service.findQuestionById(request.getParameter("questionId"));
		Member member = (Member) session.getAttribute("member");
		String memberId = member.getMemberId();
		System.out.println(memberId);
		request.setAttribute("question", post);
		if (memberId == post.getMember().getMemberId()) {
			request.getRequestDispatcher("/views/question/questionDetail.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "question/list.do");
		}

	}

}
