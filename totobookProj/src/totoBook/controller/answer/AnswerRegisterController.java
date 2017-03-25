package totoBook.controller.answer;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Answer;
import totoBook.domain.Post;
import totoBook.service.AnswerService;
import totoBook.service.QuestionService;
import totoBook.service.logic.AnswerServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/answer/register.do")
public class AnswerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String answer = req.getParameter("answerId");

		req.setAttribute("answerId", answer);
		req.getRequestDispatcher("/views/question/answerForm.jsp").forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Answer answer = new Answer();
		AnswerService answer_service = new AnswerServiceLogic();
		QuestionService question_service = new QuestionServiceLogic();
		Post post = question_service.findQuestionById(request.getParameter("postId"));
		answer.setContent(request.getParameter("content"));
		answer.setPost(post);
		answer_service.registerAnswer(answer);

		response.sendRedirect(request.getContextPath() + "/question/detail.do?questionId=" + answer.getPost().getPostId());
	}

}
