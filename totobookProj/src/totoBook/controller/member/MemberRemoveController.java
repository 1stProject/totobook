package totoBook.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
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
	
	HttpSession session = request.getSession();
	
	Member member = (Member)session.getAttribute("member");
	String memberId = member.getMemberId();
	System.out.println(memberId);
	service.removeMember(memberId);
	
	request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
	

	}

}
