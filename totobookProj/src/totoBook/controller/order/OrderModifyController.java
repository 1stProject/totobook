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
@WebServlet("/order/modify.do")
public class OrderModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService service;
	public OrderModifyController() {
		service = new OrderServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderId = request.getParameter("orderId");
		List<Order> order = service.findOrdersByOrderId(orderId);
		request.setAttribute("order", order.get(0));
		
		request.getRequestDispatcher("/views/order/orderForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("addr");
		String orderId = request.getParameter("orderId");
		List<Order> orders = service.findOrdersByOrderId(orderId);
		for(Order order : orders){
			order.setOrdWay(addr);
			service.modifyOrder(order);
		}
		response.sendRedirect(request.getContextPath()+ "/order/list.do");
	}

}
