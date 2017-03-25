package totoBook.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceLogic service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceLogic();
		Member member = new Member();
		member =service.findMemberById(request.getParameter("memberId"));
		String memberId = member.getMemberId();
		
		System.out.println(member.toString());
		if(memberId.equals("admin")){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			response.sendRedirect("list.do");
		}else{
			response.sendRedirect(request.getContextPath()+"/views/main.jsp");
			
		
			
		}			
	}
}

