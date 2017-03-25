package totoBook.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.service.ReviewService;
import totoBook.service.logic.ProductServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/product/remove.do")
public class ProductRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService productService = new ProductServiceLogic();
		ReviewService reviewService = new ReviewServiceLogic();
		
		Product product= new Product();
		product = productService.findProductById(request.getParameter("productId"));
		
		String productId = product.getProductId();
		
		productService.removeProduct(product);
		productService.removeOption(productId);
		reviewService.deleteCommentByProduct(product);
		
		response.sendRedirect("adminlist.do");
	
	
	}

}
