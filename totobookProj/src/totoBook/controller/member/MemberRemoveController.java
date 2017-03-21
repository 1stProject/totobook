package totoBook.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.MemberService;
import totoBook.service.logic.MemberServiceLogic;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/member/remove.do")
public class MemberRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MemberService service = new MemberServiceLogic();
	
	String id = request.getParameter("memberId");
	
	service.removeMember(id);
	
	request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	

	}

}
