package totoBook.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Member;
import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/modify.do")
public class ReviewModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService service;

	public ReviewModifyController() {
		service = new ReviewServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member member = (Member) request.getAttribute("member");
		service.findCommentsByMember(member);

		request.getRequestDispatcher("/views/reviewModify.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String request.getAttribute("modifyid");
		
		
	}

}
