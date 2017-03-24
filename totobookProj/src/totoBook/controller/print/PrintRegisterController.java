package totoBook.controller.print;

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

import totoBook.domain.Member;
import totoBook.domain.Photo;
import totoBook.domain.Print;
import totoBook.domain.Product;
import totoBook.service.PrintService;
import totoBook.service.ProductService;
import totoBook.service.logic.PrintServiceLogic;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author
 * @version 1.0
 */

@WebServlet("/print/register.do")
public class PrintRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private PrintService printService;
	public PrintRegisterController() {
		productService = new ProductServiceLogic();
		printService = new PrintServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		Product product = productService.findProductById(productId);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/views/print/printUpload.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024*1024*10;
		ServletContext ctx = getServletContext();
		String dir = ctx.getRealPath("/upload");
		int i = 0;
		MultipartRequest multi = new MultipartRequest(request,"c:/totobook/images" , maxSize, "UTF-8");
		List<Photo> photos = new ArrayList<>();
		Enumeration<?> params = multi.getFileNames();
		while(params.hasMoreElements()){
			String element = (String)params.nextElement();
			System.out.println(element);
			String fileName = multi.getFilesystemName(element);
			if(fileName == null){
				continue;
			} else {
				i++;
				String selectname = "amount" + i;
				System.out.println(selectname + " : " + multi.getParameter(selectname));
				Photo photo = new Photo();
				photo.setAmount(Integer.parseInt(multi.getParameter(selectname)));
				photo.setContentType(multi.getContentType(element));
				photo.setFileName(fileName);
				photos.add(photo);
				System.out.println(fileName);
			}
		}
		Print print = new Print();
		Member member = new Member();
		member.setMemberId("RURE1114");
		Product product = new Product();
		product.setProductId("2");
		print.setMember(member);
		print.setOptionDesp("반짝이는 황금색으로");
		print.setProduct(product);
		print.setPhotos(photos);
		printService.registerPrint(print);
		response.sendRedirect(request.getContextPath() + "/print/list.do");
	}

}


