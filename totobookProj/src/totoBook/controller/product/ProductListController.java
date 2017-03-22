package totoBook.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.domain.Review;
import totoBook.service.ProductService;
import totoBook.service.ReviewService;
import totoBook.service.logic.ProductServiceLogic;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ProductService productService = new ProductServiceLogic();

		
		
//		String category = request.getParameter("category");

		String category ="BOOK";
		
		List<Product> list = new ArrayList<>();
		
		list = productService.findProductsByCategory(category);
		
		System.out.println(list.size());
		
		request.setAttribute("product", list);
		request.getRequestDispatcher("/views/product/productList.jsp").forward(request, response);	
	
	}

}
