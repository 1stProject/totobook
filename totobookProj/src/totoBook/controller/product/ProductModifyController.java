package totoBook.controller.product;

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
import totoBook.domain.Photo;
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

		Product product = productService.findProductById(productId);
		System.out.println(product.toString());
		List<Option> list = new ArrayList<>();
		list = productService.findOption(productId);
		product.setOptions(productService.findOption(productId));		
		
		System.out.println("doget");
		System.out.println(productId);
		
		request.setAttribute("product", product);
		request.setAttribute("productId", productId);
		request.getRequestDispatcher("/views/product/productModify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int maxPostSize = 10 * 1024 * 1024;

		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");

		
		String productId = multi.getParameter("productId");
		System.out.println(productId);
		
		System.out.println(multi.getParameter("category"));
		
		Photo photo = new Photo();

		photo.setContentType(multi.getContentType("file1"));
		photo.setFileName(multi.getFilesystemName("file1"));

		String imageAddress = photo.getFileName();

		Product product = new Product();
		product.setCategory(multi.getParameter("category"));
		product.setName(multi.getParameter("name"));
		product.setDescript(multi.getParameter("descript"));
		product.setProductprice(Integer.parseInt(multi.getParameter("productprice")));
		product.setPhoto(photo);
		product.setImageAddress(imageAddress);
		product.setProductId(productService.findProductById(productId).getProductId());

		
		productService.modifyProduct(product);

		String[] optionname = multi.getParameterValues("optionname");
		String[] optiondesp = multi.getParameterValues("optiondesp");
		String[] optionprice = multi.getParameterValues("optionprice");

		int[] opprice = new int[optionprice.length];
		for (int i = 0; i < optionprice.length; i++) {
			opprice[i] = Integer.parseInt(optionprice[i]);
		}

		List<Option> list = new ArrayList<>();
		for (int b = 0; b < optionname.length; b++) {
			Option p = new Option();
			p.setOptionName(optionname[b]);
			p.setOptionPrice(opprice[b]);
			p.setOptionDesp(optiondesp[b]);
			p.setProduct(product);
			productService.registerOption(p);
			list.add(p);
		}

		product.setOptions(list);

		response.sendRedirect("list.do");

	}
	
	

}
