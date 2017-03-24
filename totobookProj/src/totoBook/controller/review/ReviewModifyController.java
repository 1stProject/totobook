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

import totoBook.domain.Order;
import totoBook.domain.Photo;
import totoBook.domain.Review;
import totoBook.service.OrderService;
import totoBook.service.ReviewService;
import totoBook.service.logic.OrderServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/modify.do")
public class ReviewModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService;

	public ReviewModifyController() {
		reviewService = new ReviewServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String memberId = request.getParameter("memberId");
		
		
		
		String orderId = request.getParameter("orderId");
		List<Review> list = new ArrayList<>();
		list = reviewService.findCommentByOrder((orderId));
		request.setAttribute("review", list);
		System.out.println(list.size());
		request.getRequestDispatcher("/views/review/reviewModify.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ReviewService reviewService = new ReviewServiceLogic();
		OrderService orderService = new OrderServiceLogic();
		
		
		String orderId ="3";
//		= request.getParameter("orderId");
		System.out.println(orderId);
		List<Order> list = new ArrayList<>();
		list = orderService.findOrdersByOrderId(orderId);

		Order order = list.get(0);
		
		
		System.out.println("수정");
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
		
		reviewService.modifyComment(review);
		
		response.sendRedirect("list.do");		

	}

}
