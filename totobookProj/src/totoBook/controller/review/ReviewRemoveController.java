package totoBook.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/remove.do")
public class ReviewRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewService reviewService = new ReviewServiceLogic();

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String memberId = member.getMemberId();
		if (memberId.equals("admin")) {
			String orderId = request.getParameter("orderId");
			reviewService.deleteCommentByMember(orderId);
			response.sendRedirect("adminlist.do");
		} else {
			String orderId = request.getParameter("orderId");
			reviewService.deleteCommentByMember(orderId);
			response.sendRedirect("list.do");
		}

	}

}
