package totoBook.controller.print;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.ProductService;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/print/register.do")
public class PrintRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
	public PrintRegisterController() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productId = request.getParameter("productId");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
