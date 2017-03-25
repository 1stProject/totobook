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
@WebServlet("/order/find.do")
public class OrderFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceLogic();
		final int pageSize = 5;
		int borderId = 0;
		int borderId = 0;
		if(request.getParameter("borderId") == null){
			borderId = 1;
		} else {
			borderId = Integer.parseInt(request.getParameter("borderId"));
		}
		String category = request.getParameter("category");
		List<Order> orders = null;
		List<Order> list = null;
		String search = request.getParameter("search");
		if(category.equals("orderId")){
			orders = service.findOrdersByOrderId(search);
		}
		else {
			orders = service.findOrdersByMemberId(search);
		}
		for(int i=pageSize*borderId-pageSize;i<pageSize*borderId;i++){
			if(i >= orders.size()){
				break;
			}
			else
				list.add(orders.get(i));
		}
		request.setAttribute("orders", list);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("arraysize", orders.size());
		int maxBorder = orders.size()/pageSize;
		if(orders.size() % pageSize > 0)
			maxBorder++;
		request.setAttribute("maxBorder", maxBorder);
		request.getRequestDispatcher("/views/order/orderList.jsp").forward(request, response);
	}
}
