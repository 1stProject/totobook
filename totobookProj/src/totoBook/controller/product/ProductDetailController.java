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
import totoBook.domain.Photo;
import totoBook.domain.Product;
import totoBook.domain.Review;
import totoBook.service.ProductService;
import totoBook.service.ReviewService;
import totoBook.service.logic.ProductServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

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
		ReviewService reviewService = new ReviewServiceLogic();
		
		String productId = request.getParameter("productId");
		Product product = new Product();
		product = productService.findProductById(productId);
		Photo phto = new Photo();
		String imagead = product.getImageAddress();
		phto.setContentType(imagead);
		
		product.setPhoto(phto);
		
		
		System.out.println(product.toString());
		
		List<Option> list = new ArrayList<>();
		list = productService.findOption(productId);
		product.setOptions(list);
		List<Review> list3 = new ArrayList<>();
		list3 = reviewService.findCommentsByProduct(productId);
		request.setAttribute("review", list3);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/product/productDetail.jsp").forward(request, response);

	}

}
