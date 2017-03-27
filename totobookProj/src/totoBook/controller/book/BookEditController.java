package totoBook.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Book;
import totoBook.domain.Page;
import totoBook.service.BookService;
import totoBook.service.logic.BookServiceLogic;


/**
 * @author juhee Kim
 * @version 1.0
 */

@WebServlet("/book/edit.do")
public class BookEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = new BookServiceLogic();
		String bookId = request.getParameter("bookId");
		
		request.setAttribute("book", service.findBook(bookId));
		
		request.getRequestDispatcher("/views/book/bookForm.jsp").forward(request, response);

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = new BookServiceLogic();
		ServletContext ctx = getServletContext();
		String dir = ctx.getRealPath("/upload");
		
		MultipartRequest multi = new MultipartRequest(request, dir);
				
		String bookId = multi.getParameter("bookId");
		String bookName = multi.getParameter("bookName");
		System.out.println("아이디"+bookId);
		
		Book book = service.findBook(bookId);
		book.setBookName(bookName);
		System.out.println(book.getBookName());
		Date date = new Date();
		
		List<Page> pages = book.getPages();
		List<Page> pages2 = new ArrayList<>();
		int i=0;
		for(Page page : pages){
			i++;
			page.setImageAddress(multi.getParameter("pageInput"+i));
			pages2.add(page);
		}
		book.setPages(pages2);
//		book.setBookName(multi.getParameter("bookName"));
		
		service.modifyBook(book);		
		
		response.sendRedirect(request.getContextPath()+"/book/list.do");
	}

}
