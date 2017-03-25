package totoBook.controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Book;
import totoBook.domain.Member;
import totoBook.service.BookService;
import totoBook.service.logic.BookServiceLogic;

/**
 * @author 김주희
 * @version 1.0
 */
@WebServlet("/book/list.do")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		BookService service = new BookServiceLogic();
		
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		List<Book> books = service.findBooksByMemberId(memberId);
		
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("/views/book/bookList.jsp").forward(request, response);
		
		
	}

}
