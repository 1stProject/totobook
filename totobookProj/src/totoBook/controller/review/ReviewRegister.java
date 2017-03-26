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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Book;
import totoBook.domain.Member;
import totoBook.domain.Order;
import totoBook.domain.Photo;
import totoBook.domain.Print;
import totoBook.domain.Product;
import totoBook.domain.Review;
import totoBook.service.BookService;
import totoBook.service.MemberService;
import totoBook.service.OrderService;
import totoBook.service.PrintService;
import totoBook.service.ProductService;
import totoBook.service.ReviewService;
import totoBook.service.logic.BookServiceLogic;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.OrderServiceLogic;
import totoBook.service.logic.PrintServiceLogic;
import totoBook.service.logic.ProductServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/review/register.do")
public class ReviewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderService orderService = new OrderServiceLogic();
		
		String orderId= request.getParameter("orderId");
		List<Order> list = new ArrayList<>();
		list = orderService.findOrdersByOrderId(orderId);
		Order order = list.get(0);
	
		
		request.setAttribute("order", order);
		
		request.getRequestDispatcher("/views/review/reviewForm.jsp").forward(request, response);
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReviewService reviewService = new ReviewServiceLogic();
		OrderService orderService = new OrderServiceLogic();
		ProductService productService = new ProductServiceLogic();
		
		HttpSession session = request.getSession();

		int maxPostSize = 10 * 1024 * 1024;
		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/review");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");
		
		
		String orderId= multi.getParameter("orderId");

		List<Order> list = new ArrayList<>();
		list = orderService.findOrdersByOrderId(orderId);
		
		
		Order order = list.get(0);
		Member member = (Member)session.getAttribute("member");

		
		
		
		Photo photo = new Photo();

		photo.setContentType(multi.getContentType("file1"));
		photo.setFileName(multi.getFilesystemName("file1"));

		String imageAddress = photo.getFileName();

		Review review = new Review();
		review.setComment(multi.getParameter("comment"));
		if (imageAddress == null) {
			review.setImageAddress("");
		} else {
			review.setImageAddress(imageAddress);
		}
		
		
		review.setOrder(order);
		review.setMember(list.get(0).getMember());
		Product product = new Product();
		if(list.get(0).getCategory().equals("사진")){
			PrintService service = new PrintServiceLogic();
			Print print = service.findPrintByPrintId(list.get(0).getBookPhotoId());
			product = print.getProduct();
		}
		else{
			BookService service = new BookServiceLogic();
			Book book = service.findBook(list.get(0).getBookPhotoId());
			product = book.getProduct();
		}
		review.setProduct(product);
		reviewService.registerComment(review);
		

		
		response.sendRedirect("list.do");
		
		
		
	}

}
