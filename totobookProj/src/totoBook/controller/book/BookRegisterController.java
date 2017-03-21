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
import totoBook.domain.Page;
import totoBook.domain.Photo;
import totoBook.domain.Product;
import totoBook.service.BookService;
import totoBook.service.logic.BookServiceLogic;

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
		Member member = new Member();
		Product product = new Product();
		HttpSession session = request.getSession();
		
		String memberId = (String)session.getAttribute("memberId");
		member.setMemberId(memberId);
		
		String productId = (String)request.getAttribute("productId");
		int pageOption = (Integer)request.getAttribute("pageOption");
		String sizeOption = (String)request.getAttribute("sizeOption");
		
		product.setProductid(productId);
		book.setBookName((String) request.getAttribute("productName"));
		book.setMember(member);
		book.setProduct(product);
		
		List<Page> pages = new ArrayList<>();
		
		int layoutnum = 1;
		for(int i = 0; i < pageOption; i ++){
			Page page = new Page();
			page.setBook(book);
			page.setImageAddress("/images/pageLayout/"+sizeOption+"_default_layout_"+layoutnum+".jpg");
			
			pages.add(page);
			
			layoutnum++;
			if(layoutnum == 11){
				layoutnum = 1;
			}
		}
		
		book.setPages(pages);
		service.registerBook(book);
		
		response.sendRedirect(request.getContextPath()+"/book/list.do");
	}

}
