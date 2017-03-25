package totoBook.controller.review;

import java.io.IOException;
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
 * Servlet implementation class ReviewAdminListController
 */
@WebServlet("/review/adminlist.do")
public class ReviewAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService reviewService = new ReviewServiceLogic();

		List<Review> list = reviewService.findAllComents();
		request.setAttribute("review", list);
		request.getRequestDispatcher("/views/review/reviewManage.jsp").forward(request, response);
	}

}
