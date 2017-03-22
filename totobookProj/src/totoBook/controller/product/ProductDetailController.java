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
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/product/detail.do")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService productService = new ProductServiceLogic();

		String productId = request.getParameter("productId");

		Product product = new Product();
		product = productService.findProductById(productId);
		
		
		List<Option> list = new ArrayList<>();
		List<Option> lis1 = new ArrayList<>();

		list = productService.findOption(productId);
		
		
		product.setOptions(productService.findOption(productId));

		
		System.out.println(product.getOptions().get(0).getOptionName());

		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/product/productDetail.jsp").forward(request, response);

	}

}
