package totoBook.controller.print;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.service.PrintService;
import totoBook.service.logic.PrintServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/print/remove.do")
public class PrintRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintService service = new PrintServiceLogic();
		
		String printId = request.getParameter("printId");
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
		service.removePhotos(printId);
		service.removePrint(printId);
		
		request.setAttribute("memberId", memberId);
		response.sendRedirect("/views/print/printList.jsp");
	}
}
