package totoBook.controller.member;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Member;
import totoBook.service.MemberService;
import totoBook.service.logic.MemberServiceLogic;


@WebServlet("/member/register.do")
public class MemberRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String memberId = request.getParameter("memberId");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String receiveEmail = request.getParameter("receiveEmail");
	Member member = new Member();
	
	member.setMemberId(memberId);
	member.setName(name);
	member.setPassword(password);
	member.setAddress(address);
	member.setPhone(phone);
	member.setReceiveEmail(receiveEmail);
	
	MemberService service = new MemberServiceLogic();
	
	service.registerMember(member);
	
	response.sendRedirect("find.do");
	
	
	}

}

