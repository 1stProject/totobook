package totoBook.controller.answer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import totoBook.domain.Answer;
import totoBook.domain.Post;
import totoBook.service.AnswerService;
import totoBook.service.logic.AnswerServiceLogic;

@WebServlet("/answer/detail.do")
public class AnswerDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnswerService service = new AnswerServiceLogic();
		Answer answer = new Answer();
		answer = service.findAnswerById(request.getParameter("postId"));
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(answer);
		System.out.println("answer : " + json);
		try {
			response.getWriter().print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
