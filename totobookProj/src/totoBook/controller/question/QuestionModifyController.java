package totoBook.controller.question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/modify.do")
public class QuestionModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();
		Post post = service.findQuestionById(request.getParameter("questionId"));

		request.setAttribute("question", post);
		request.getRequestDispatcher("/views/question/questionModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		QuestionService service = new QuestionServiceLogic();
		post.setTitle(request.getParameter("question_title"));
		post.setContent(request.getParameter("content"));
		post.setImageAddressPath("");
		post.setImage_ext("");

		service.modifyQuestion(post);

		request.setAttribute("questionId", post.getPostId());
		request.getRequestDispatcher("QuestionDetail.do").forward(request, response);
	}

}
