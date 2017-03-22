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


@WebServlet("/question/detail.do")
public class QuestionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Post post = new Post();
		QuestionService service = new QuestionServiceLogic();
		post = service.findQuestionById(request.getParameter("questionId"));
	
		request.setAttribute("question", post);
		request.getRequestDispatcher("/views/question/questionDetail.jsp").forward(request, response);
	
	}

}
