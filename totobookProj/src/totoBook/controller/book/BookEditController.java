package totoBook.controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Book;
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
		
		/*
		request.getRequestDispatcher("/views/book/cropper/examples/multiple-croppers.jsp").forward(request, response);
	*/
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("이야!");
		BookService service = new BookServiceLogic();
		
		String bookId = request.getParameter("bookId");
		
		Book book = service.findBook(bookId);
//		List<Page> pages = request.getParameter();
		
		book.setBookName(request.getParameter("bookName"));
		
		service.modifyBook(book);		
		
		response.sendRedirect(request.getContextPath()+"/book/list.do");
	}

}
