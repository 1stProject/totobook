package totoBook.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
import totoBook.store.ProductStore;

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
		productService.registerProduct(product);		
		
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
