package totoBook.controller.question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;

import totoBook.domain.Member;
import totoBook.domain.Photo;
import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/register.do")
public class QuestionRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// request.getContextPath()+"/views/question/questionList.jsp"

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		QuestionService service = new QuestionServiceLogic();
		HttpSession session = request.getSession();
		post.setTitle(request.getParameter("question_title"));
		post.setContent(request.getParameter("content"));
		post.setImageAddressPath("");
		post.setImage_ext("");
		Member member = (Member) session.getAttribute("member");
		post.setMember(member);
		service.registerQuestion(post);

		response.sendRedirect(request.getContextPath() + "/question/list.do");

	}

}
