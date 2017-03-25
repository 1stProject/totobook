package totoBook.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService productService = new ProductServiceLogic();

//		HttpSession session = request.getSession();
//		System.out.println("list테스트");
//		Member member = (Member) session.getAttribute("member");
//
//		System.out.println(member);
//		String memberId = member.getMemberId();
//		System.out.println(memberId);
//		String admin = "admin";
//
//		if (memberId == admin) {
//			List<Product> list = new ArrayList<>();
//			list = productService.findAllProducts();
//			System.out.println("1");
//			request.setAttribute("product", list);
//			request.getRequestDispatcher("/views/product/prodcutManage.jsp").forward(request, response);
//		}

			String category = request.getParameter("category");
			List<Product> list = new ArrayList<>();
			list = productService.findProductsByCategory(category);
			request.setAttribute("product", list);
			request.getRequestDispatcher("/views/product/productList.jsp").forward(request, response);

		}

}
