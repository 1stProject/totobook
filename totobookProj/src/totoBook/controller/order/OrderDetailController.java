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
import totoBook.domain.Print;
import totoBook.service.BookService;
import totoBook.service.OrderService;
import totoBook.service.PrintService;
import totoBook.service.logic.BookServiceLogic;
import totoBook.service.logic.OrderServiceLogic;
import totoBook.service.logic.PrintServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/order/detail.do")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceLogic();
		PrintService printService = new PrintServiceLogic();
		BookService bookService = new BookServiceLogic();
		String orderId = request.getParameter("orderId");
		
		List<Order> orders = service.findOrdersByOrderId(orderId);
		Order order = orders.get(0);
		if(order.getCategory().equals("사진")){
			Print print = printService.findPrintByPrintId(order.getBookPhotoId());
			request.setAttribute("print", print);
		}
		else {
			Book book = bookService.findBook(order.getBookPhotoId());
			System.out.println(book.toString());
			request.setAttribute("book", book);
		}
		request.setAttribute("order", order);
		
		request.getRequestDispatcher("/views/order/orderDetail.jsp").forward(request, response);
	}

}
