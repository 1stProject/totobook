package totoBook.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.service.logic.ProductServiceLogic;

/**
 * Servlet implementation class ProductAdminListController
 */
@WebServlet("/product/adminlist.do")
public class ProductAdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ProductService productService = new ProductServiceLogic();

		List<Product> list = new ArrayList<>();
		list = productService.findAllProducts();
		request.setAttribute("product", list);
		request.getRequestDispatcher("/views/product/prodcutManage.jsp").forward(request, response);
		
	
	}

}
