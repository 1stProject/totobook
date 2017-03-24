package totoBook.controller.answer;

import java.io.IOException;
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


@WebServlet("/answer/modify.do")
public class AnswerModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService service = new AnswerServiceLogic();
		Answer answer = service.findAnswerById(request.getParameter("answerId"));
		
		request.setAttribute("answer", answer);
		request.getRequestDispatcher("/views/question/answerModify.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Answer answer = new Answer();
		AnswerService answer_service = new AnswerServiceLogic();
		QuestionService question_service = new QuestionServiceLogic();
		Post post = question_service.findQuestionById(request.getParameter("postId"));//? parameter 맞나?
		answer.setContent(request.getParameter("content"));
		answer.setPost(post);
		System.out.println(post.getPostId());
		answer_service.modifyAnswer(answer);
		
		response.sendRedirect(request.getContextPath() + "/question/detail.do?questionId="+post.getPostId());
	}

}
