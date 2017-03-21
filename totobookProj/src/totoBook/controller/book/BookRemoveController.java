package totoBook.controller.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.BookService;
import totoBook.service.logic.BookServiceLogic;


/**
 * @author juhee Kim
 * @version 1.0
 */

@WebServlet("/book/remove.do")
public class BookRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = new BookServiceLogic();
		String bookId = request.getParameter("bookId");
		
		service.removeBook(bookId);		
		
		response.sendRedirect(request.getContextPath()+"/book/list.do");
	}

}

