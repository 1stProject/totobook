package totoBook.controller.question;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;


@WebServlet("/question/remove.do")
public class QuestionRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();
		
		service.removeQuestion(request.getParameter("questionId"));
		
		response.sendRedirect("question/remove.do");
	}

}
