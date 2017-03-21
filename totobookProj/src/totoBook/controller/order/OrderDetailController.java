package totoBook.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Order;
import totoBook.service.OrderService;
import totoBook.service.logic.OrderServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/order/detail.do")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceLogic();
		String orderId = request.getParameter("orderId");
		
		List<Order> order = service.findOrdersByOrderId(orderId);
		request.setAttribute("orders", order);
		
		request.getRequestDispatcher("/views/order/orderDetail.jsp").forward(request, response);
	}

}
