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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Member;
import totoBook.domain.Option;
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
		String price = request.getParameter("price");
		Product product = productService.findProductById(productId);
		request.setAttribute("product", product);
		String optionDesp = "";
		optionDesp += request.getParameter("option1") + ";";
		optionDesp += request.getParameter("size");
		request.setAttribute("price", price);
		System.out.println(price);
		request.setAttribute("optionDesp", optionDesp);
		System.out.println(optionDesp);
		request.getRequestDispatcher("/views/print/printUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024*1024*10;
		ServletContext ctx = getServletContext();
		String dir = ctx.getRealPath("/upload");
		int i = 0;
		List<Photo> photos = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		MultipartRequest multi = new MultipartRequest(request, dir , maxSize, "UTF-8");
		Enumeration<?> params = multi.getFileNames();
		while(params.hasMoreElements()){
			String element = (String)params.nextElement();
			System.out.println("element : " + element);
			String fileName = multi.getFilesystemName(element);
			if(fileName == null){
				continue;
			} else {
				i++;
				String selectname = "amount" + i;
				Photo photo = new Photo();
				temp.add(Integer.parseInt(multi.getParameter(selectname)));
				photo.setContentType(multi.getContentType(element));
				photo.setFileName(fileName);
				photos.add(photo);
			}
		}
		
		for(int k=0;k<temp.size();k++){
			photos.get(k).setAmount(temp.get(temp.size()-1-k));
		}
		
		Print print = new Print();
		HttpSession session = request.getSession();
		System.out.println("업로드 될때 price : " + multi.getParameter("price"));
		print.setPrice(Integer.parseInt(multi.getParameter("price")));
		Member member = (Member)session.getAttribute("member");
		String productId = multi.getParameter("productId");
		Product product = productService.findProductById(productId);
		product.setOptions(productService.findOption(productId));
		print.setMember(member);
		List<Option> options = product.getOptions();
		System.out.println("option size : " + options.size());
		String optionString = multi.getParameter("optionDesp");
		
		print.setOptionDesp(optionString);
		print.setProduct(product);
		print.setPhotos(photos);
		printService.registerPrint(print);
		response.sendRedirect(request.getContextPath() + "/print/list.do");
	}

}


