package totoBook.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/remove.do")
public class ReviewRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService reviewService = new ReviewServiceLogic();

		String orderId = request.getParameter("orderId");
		
		reviewService.deleteCommentByMember(orderId);

		response.sendRedirect("list.do");
		
	
	}


}
