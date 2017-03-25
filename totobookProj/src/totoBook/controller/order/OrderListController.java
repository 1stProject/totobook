package totoBook.controller.order;

import java.io.IOException;
import java.util.ArrayList;
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
	private final int pageSize = 5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceLogic();
		List<Order> temp = null;
		List<Order> list = new ArrayList<>();
		int borderId = 0;
		if(request.getParameter("borderId") == null){
			borderId = 1;
		} else {
			borderId = Integer.parseInt(request.getParameter("borderId"));
		}
		String memberId = "admin";
		if(memberId != "admin"){
			temp = service.findOrdersByMemberId(memberId);
			for(int i=pageSize*borderId-pageSize;i<pageSize*borderId;i++){
				if(i >= temp.size()){
					break;
				}
				else
					list.add(temp.get(i));
			}
			request.setAttribute("orders", list);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("arraysize", temp.size());
			int maxBorder = temp.size()/pageSize;
			if(temp.size() % pageSize > 0)
				maxBorder++;
			request.setAttribute("maxBorder", maxBorder);
			request.setAttribute("size", temp.size());
			request.getRequestDispatcher("/views/order/orderMemberList.jsp").forward(request, response);
		}
		else{
			temp = service.findAllOrders();
			for(int i=pageSize*borderId-pageSize;i<pageSize*borderId;i++){
				if(i >= temp.size()){
					break;
				}
				else
					list.add(temp.get(i));
			}
			request.setAttribute("orders", list);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("arraysize", temp.size());
			int maxBorder = temp.size()/pageSize;
			if(temp.size() % pageSize > 0)
				maxBorder++;
			request.setAttribute("maxBorder", maxBorder);
			request.getRequestDispatcher("/views/order/orderList.jsp").forward(request, response);
		}
	}
}
