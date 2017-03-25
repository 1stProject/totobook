package totoBook.controller.question;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/question/list.do")
public class QuestionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();

		List<Post> list = service.findAllQuestion();

		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("member");

		session.setAttribute("member", member);
		request.setAttribute("questionList", list);

		request.getRequestDispatcher("/views/question/questionList.jsp").forward(request, response);
	}

}
