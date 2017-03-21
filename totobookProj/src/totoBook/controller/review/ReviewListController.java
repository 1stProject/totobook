package totoBook.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Member;
import totoBook.domain.Review;
import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/list.do")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReviewService service = new ReviewServiceLogic();
		
		
		request.getAttribute("member");

		Member member = (Member) request.getAttribute("member");
		member.setName("RURE1114");
		
		List<Review> list = service.findCommentsByMember(member);
		System.out.println(list);
		request.setAttribute("review", list);
		request.getRequestDispatcher("/views/reviewList.jsp").forward(request, response);	
		

	}

}
