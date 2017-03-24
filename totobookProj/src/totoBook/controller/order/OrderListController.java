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
@WebServlet("/order/list.do")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceLogic();
		List<Order> list = null;
		
		String memberId = "admin";
		if(memberId != "admin"){
			list = service.findOrdersByMemberId(memberId);
			request.setAttribute("orders", list);
			request.getRequestDispatcher("/views/order/orderMemberList.jsp").forward(request, response);
		}
		else{
			list = service.findAllOrders();
			request.setAttribute("orders", list);
			request.getRequestDispatcher("/views/order/orderList.jsp").forward(request, response);
		}
	}
}
