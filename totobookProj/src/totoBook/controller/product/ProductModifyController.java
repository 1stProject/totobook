package totoBook.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Option;
import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/product/modify.do")
public class ProductModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService;

	public ProductModifyController() {
		productService = new ProductServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");

		Product proudct = productService.findProductById(productId);

		request.setAttribute("product", proudct);
		request.getRequestDispatcher("/views/productModify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Product product = new Product();
		
		product.setCategory(request.getParameter("productId"));
		product.setName(request.getParameter("productId"));
		product.setProductprice(Integer.parseInt(request.getParameter("productId")));
		product.setImageAddress(request.getParameter("productId"));
		List<Option> list = new ArrayList<>();
		list = productService.findOption(request.getParameter("productId"));
		
		
		
//		product.setOptions(request.getAttribute("option"));
		
		
		
	
	
	}

}
