package totoBook.controller.answer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Answer;
import totoBook.service.AnswerService;
import totoBook.service.logic.AnswerServiceLogic;
import totoBook.store.AnswerStore;

@WebServlet("/answer/remove.do")
public class AnswerRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService service = new AnswerServiceLogic();
		service.removeAnswer(request.getParameter("answerId"));
		
		response.sendRedirect("/views/question/questionDetail.jsp");
	}

}
