package totoBook.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Book;
import totoBook.domain.Order;
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
	ProductService productService = null;
	public OrderRegisterController() {
		orderService = new OrderServiceLogic();
		productService = new ProductServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String printId = request.getParameter("printId");
		Order order = new Order();
		if(printId != null){
			PrintService printService = new PrintServiceLogic();
			Print print = printService.findPrintByPrintId(printId);
			
			order.setBookPhotoId(printId);
			order.setCategory("사진");
			order.setMember(print.getMember());
			order.setOrdPrice(35000);
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
		System.out.println("bookPhotoId : " + request.getParameter("bookPhotoId"));
		System.out.println("category : " + request.getParameter("category"));
		System.out.println("member : " +memberService.findMemberById(request.getParameter("memberId").toString()));
		System.out.println(request.getParameter("payment"));
		orderService.registerOrder(order);
		response.sendRedirect(request.getContextPath() + "/order/list.do");
	}
	
}
