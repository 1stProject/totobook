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
import totoBook.store.AnswerStore;

@WebServlet("/answer/remove.do")
public class AnswerRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService service = new AnswerServiceLogic();
		QuestionService q_service = new QuestionServiceLogic();
		String postId = request.getParameter("answerId");
		service.removeAnswer(postId);
		Post post = q_service.findQuestionById(postId);
		
		request.setAttribute("question", post);
		request.getRequestDispatcher("/views/question/questionDetail.jsp").forward(request, response);;
	}

}
