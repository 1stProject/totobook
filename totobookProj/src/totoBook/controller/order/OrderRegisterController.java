package totoBook.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Book;
import totoBook.domain.Order;
import totoBook.domain.Photo;
import totoBook.domain.Print;
import totoBook.domain.Product;
import totoBook.service.BookService;
import totoBook.service.MemberService;
import totoBook.service.OrderService;
import totoBook.service.PrintService;
import totoBook.service.ProductService;
import totoBook.service.logic.BookServiceLogic;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.OrderServiceLogic;
import totoBook.service.logic.PrintServiceLogic;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/order/register.do")
public class OrderRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService = null;
	public OrderRegisterController() {
		orderService = new OrderServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String printId = request.getParameter("printId");
		Order order = new Order();
		int price = 0;
		if(printId != null){
			PrintService printService = new PrintServiceLogic();
			Print print = printService.findPrintByPrintId(printId);
			System.out.println(print.getPrice());
			List<Photo> photos = printService.findPhotosByPrintId(printId);
			order.setBookPhotoId(printId);
			order.setCategory("사진");
			order.setMember(print.getMember());
			for(Photo photo : photos){
				System.out.println("print price : " + print.getPrice());
				price += photo.getAmount()*print.getPrice();
			}
			order.setOrdPrice(price);
		}
		else {
			String bookId = request.getParameter("bookId");
			BookService bookService = new BookServiceLogic();
			Book book = bookService.findBook(bookId);
			order.setBookPhotoId(bookId);
			order.setCategory("포토북");
			order.setMember(book.getMember());
		}

		request.setAttribute("order", order);
		request.getRequestDispatcher("/views/order/orderForm.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceLogic();
		Order order = new Order();
		order.setBookPhotoId(request.getParameter("bookPhotoId"));
		order.setCategory(request.getParameter("category"));
		order.setMember(memberService.findMemberById(request.getParameter("memberId")));
		order.setPayment(request.getParameter("payment"));
		order.setOrdPrice(Integer.parseInt(request.getParameter("price")));
		orderService.registerOrder(order);
		response.sendRedirect(request.getContextPath() + "/order/list.do");
	}
	
}
