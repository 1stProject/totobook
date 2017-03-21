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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService productService = new ProductServiceLogic();
		

		int maxPostSize = 10 * 1024 * 1024;

		response.setContentType("text/html; charset=UTF-8");

		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");


		MultipartRequest multi = new MultipartRequest((HttpServletRequest) response, dir, maxPostSize, "UTF-8");

		
		File file1 = multi.getFile("file1");
		File file2 = multi.getFile("file2");
//file이 null일떄 
		
		String imageAddress = file1.getAbsolutePath();
		
		
		String[] optionname = multi.getParameterValues("optionname");
		String[] optiondesp = multi.getParameterValues("optiondesp");
		String[] optionprice = multi.getParameterValues("optionprice") ;
		int[] opprice = new int[optionprice.length];
		//이렇게 for문으로 풀어서 변환 작업을 해야 한다.
		for(int i = 0; i<optionprice.length; i++){
			opprice[i] = Integer.parseInt(optionprice[i]);
		}
		
//option리스트
		List<Option> list = new ArrayList<>();
			for (int b = 0; b < optionname.length; b++) {
				Option p = new Option();
				p.setOptionName(optionname);
				p.setOptionPrice(opprice);
				p.setOptionDesp(optiondesp);
				productService.registerOption(p);
				//여기에 productid를 주면 만사해결
				list.add(p);
			}
		

		
		
//시나리오1
//option 도메인에 productid를 주고 이것을 통해서 productid를 set으로 받아오고 수정을 한다.
//	option.setOptionName(request.getParameter("optionname"));
//	option.setOptionDesp(request.getParameter("optiondesp"));
//	option.setOptionPrice(Integer.parseInt(request.getParameter("optionprice")));

		
		
//시나리오2
//product를 처음으로 시작하고 productid를 붙이다? 하지만 여전히 option을 설정할때 받을수는 없다?
//배열로 받는다?	현재 시나리오2로 코딩 수정 하지만 아직까지의 문제점 productid를 어떻게 옵션에 주는가!?!
		
		
		
		
		Product product = new Product();
		product.setCategory(multi.getParameter("category"));
		product.setName(multi.getParameter("name"));
		product.setDescript(multi.getParameter("descript"));
		product.setImageAddress(multi.getParameter(""));
		product.setProductprice(Integer.parseInt(multi.getParameter("productprice")));
		product.setOptions(list);
		product.setImageAddress(imageAddress);
		product.setQuantity(1);
		//setqunatity는 무엇인가?

		productService.registerProduct(product);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/productModify.jsp").forward(request, response);		
		
		response.sendRedirect("views/productManage.jsp");
	
	}

}

// String imageAddress = request

// Enumeration params = multi.getParameterNames();
// Enumeration files = multi.getFileNames(request.getParameter("file"));

// String imageAddress = multi.getParameter(java.lang.String name);
