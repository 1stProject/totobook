package totoBook.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Option;
import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/product/register.do")
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService productService = new ProductServiceLogic();

		
		System.out.println("등록");
		
		int maxPostSize = 10 * 1024 * 1024;

		response.setContentType("text/html; charset=UTF-8");

		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");

		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");

		File file1 = multi.getFile("file1");
		File file2 = multi.getFile("file2");
		// file이 null일떄

		String imageAddress = file1.getAbsolutePath();

		String[] optionname = multi.getParameterValues("optionname");
		String[] optiondesp = multi.getParameterValues("optiondesp");
		String[] optionprice = multi.getParameterValues("optionprice");
		int[] opprice = new int[optionprice.length];
		// 이렇게 for문으로 풀어서 변환 작업을 해야 한다.
		for (int i = 0; i < optionprice.length; i++) {
			opprice[i] = Integer.parseInt(optionprice[i]);
		}

		Product product = new Product();
		product.setCategory(multi.getParameter("category"));
		product.setName(multi.getParameter("name"));
		product.setDescript(multi.getParameter("descript"));
		product.setImageAddress(multi.getParameter(""));
		product.setProductprice(Integer.parseInt(multi.getParameter("productprice")));
		product.setImageAddress(imageAddress);
		productService.registerProduct(product);


		// option리스트
		List<Option> list = new ArrayList<>();
		for (int b = 0; b < optionname.length; b++) {
			Option p = new Option();
			p.setOptionName(optionname[b]);
			p.setOptionPrice(opprice[b]);
			p.setOptionDesp(optiondesp[b]);
			p.setOptionId(product.getProductId());
			productService.registerOption(p);
			list.add(p);
		}

		product.setOptions(list);

		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/productModify.jsp").forward(request, response);

		response.sendRedirect("views/productManage.jsp");

	}

}
