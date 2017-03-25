package totoBook.controller.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Review;
import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * Servlet implementation class ReviewDetailController
 */
@WebServlet("/review/detail.do")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService reviewService = new ReviewServiceLogic();

		
		String orderId = request.getParameter("orderId");
		List<Review> list = new ArrayList<>();
		list = reviewService.findCommentByOrder((orderId));
		request.setAttribute("review", list);
		System.out.println(list.size());
		request.getRequestDispatcher("/views/review/reviewDetail.jsp").forward(request, response);
		
	
	
	}

}
