package totoBook.controller.question;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/list.do")
public class QuestionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();
		System.out.println("done");
		List<Post> list = service.findAllQuestion();

		request.setAttribute("questionList", list);
	
		request.getRequestDispatcher("/views/question/questionList.jsp").forward(request, response);
	}

}
