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
import totoBook.service.MemberService;
import totoBook.service.ReviewService;
import totoBook.service.logic.MemberServiceLogic;
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
		MemberService service1 = new MemberServiceLogic();

		request.getAttribute("member");
		// userId를 받아온다 세션에 있나?

		Member member = service1.findMemberById("RURE1114");
		String memberId = member.getMemberId();

		List<Review> list = service.findCommentsByMember(memberId);

		request.setAttribute("review", list);
		request.getRequestDispatcher("/views/review/reviewList.jsp").forward(request, response);

	}

}
