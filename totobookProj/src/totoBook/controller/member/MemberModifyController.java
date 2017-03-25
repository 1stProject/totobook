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

@WebServlet("/member/modify.do")
public class MemberModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceLogic();
		String id = request.getParameter("memberId");
		Member member = service.findMemberById(id);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/views/member/memberModify.jsp").forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("memberId");
		String phone = request.getParameter("memberPhone");
		String password = request.getParameter("memberPassword");
		String address = request.getParameter("memberAddress");
		String email = request.getParameter("memberEmail");
		
		MemberService service = new MemberServiceLogic();
		Member member = new Member();
		member.setMemberId(id);
		member.setPhone(phone);
		member.setPassword(password);
		member.setAddress(address);
		member.setReceiveEmail(email);
		service.modifyMember(member);
		
		response.sendRedirect(request.getContextPath()+"/views/main.jsp");
	}

}
