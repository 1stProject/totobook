package totoBook.controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Order;
import totoBook.domain.Print;
import totoBook.domain.Product;
import totoBook.service.MemberService;
import totoBook.service.OrderService;
import totoBook.service.PrintService;
import totoBook.service.ProductService;
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
		ProductService = new ProductServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String printId = request.getParameter("printId");
		if(printId != null){
			PrintService printService = new PrintServiceLogic();
			Print print = printService.findPrintByPrintId(printId);
			Order order = new Order();
			order.setMember(print.getMember());
			request.setAttribute("order", order);
		}
		request.getRequestDispatcher("/views/order/orderForm.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceLogic();
		ProductService productService = new ProductServiceLogic();
		Order order = new Order();
		Product product = productService.findProductById(productId);
		product.setProductId("1");
		order.setMember(memberService.findMemberById(request.getParameter("memberId")));
		order.setPayment(request.getParameter("payment"));
		order.setProduct(product);
		order.setOrdPrice(Integer.parseInt(request.getParameter("price")));
		orderService.registerOrder(order);	
		response.sendRedirect(request.getContextPath() + "/order/list.do");
	}
	
}
