package totoBook.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Book;
import totoBook.domain.Member;
import totoBook.domain.Option;
import totoBook.domain.Page;
import totoBook.domain.Product;
import totoBook.service.BookService;
import totoBook.service.ProductService;
import totoBook.service.logic.BookServiceLogic;
import totoBook.service.logic.ProductServiceLogic;

/**
 * @author 김주희
 * @version 1.0
 */

@WebServlet("/book/register.do")
public class BookRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		BookService service = new BookServiceLogic();
		ProductService productService = new ProductServiceLogic();
		HttpSession session = request.getSession();
		
		Member member = (Member)session.getAttribute("member");
		System.out.println(member.getMemberId());
		
		String productId = request.getParameter("productId");
		String sizeOption = request.getParameter("size");
		int pageOption = Integer.parseInt(request.getParameter("pageOption"));
		
		Product product = productService.findProductById(productId);
		product.setOptions(productService.findOption(productId));
		
		book.setBookName(product.getName());
		
		String optionValue="";
		List<Option> optionList = product.getOptions();
		for(Option option : optionList){
			optionValue += option.getOptionName() +" : "+ request.getParameter(option.getOptionName())+"\t";
		}
		System.out.println(optionValue);
		book.setOption(optionValue);
		book.setMember(member);
		book.setProduct(product);
		
		List<Page> pages = new ArrayList<>();
		
		int layoutnum = 1;
		for(int i = 0; i < pageOption; i ++){
			Page page = new Page();
			page.setBook(book);
			if(layoutnum == 0 || layoutnum == (pageOption-1)){
				page.setImageAddress("/images/pageLayout/"+sizeOption+"_layout_"+layoutnum+".jpg");
				
			}
			page.setImageAddress("/images/pageLayout/"+sizeOption+"_blue_layout_"+layoutnum+".jpg");
			
			pages.add(page);
			
			layoutnum++;
			if(layoutnum == 4 ){
				layoutnum = 1;
			}
		}
		
		book.setPages(pages);
		System.out.println(book.toString());
		service.registerBook(book);
		
		response.sendRedirect(request.getContextPath()+"/book/list.do");
	}

}
