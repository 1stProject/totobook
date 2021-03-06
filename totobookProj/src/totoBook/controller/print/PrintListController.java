package totoBook.controller.print;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.domain.Print;
import totoBook.service.PrintService;
import totoBook.service.logic.PrintServiceLogic;

@WebServlet("/print/list.do")
public class PrintListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintService service = new PrintServiceLogic();
		
		HttpSession session = request.getSession();
		
		Member member = (Member)session.getAttribute("member");
		String memberId = member.getMemberId();
		List<Print> list = service.findPrintsByMemberId(memberId);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/print/printList.jsp").forward(request, response);
	}
}
