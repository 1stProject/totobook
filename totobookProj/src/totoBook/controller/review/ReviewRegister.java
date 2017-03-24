package totoBook.controller.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Member;
import totoBook.domain.Order;
import totoBook.domain.Photo;
import totoBook.domain.Review;
import totoBook.service.MemberService;
import totoBook.service.OrderService;
import totoBook.service.ReviewService;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.OrderServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/register.do")
public class ReviewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReviewService reviewService = new ReviewServiceLogic();
		OrderService orderService = new OrderServiceLogic();
		MemberService memberService = new MemberServiceLogic();
		
		String orderId= request.getParameter("orderId");
		List<Order> list = new ArrayList<>();
		list = orderService.findOrdersByOrderId(orderId);
		Order order = list.get(0);
		Member member = memberService.findMemberById("RURE1114");
		int maxPostSize = 10 * 1024 * 1024;
		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/review");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");

		Photo photo = new Photo();

		photo.setContentType(multi.getContentType("file1"));
		photo.setFileName(multi.getFilesystemName("file1"));

		String imageAddress = photo.getFileName();

		Review review = new Review();
		review.setComment(multi.getParameter("comment"));
		review.setImageAddress(imageAddress);
		review.setOrder(order);
		
		
		reviewService.registerComment(review);
		


		
		response.sendRedirect("list.do");
		
		
		
	}

}
