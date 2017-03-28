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
@WebServlet("/member/loginCheck.do")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceLogic service;	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceLogic();
		String inputId = request.getParameter("id");
		String inputPw = request.getParameter("password");
		
		Member member = service.findMemberById(inputId);
		PrintWriter out = response.getWriter();
		
		if(member!=null && member.getPassword().equals(inputPw)){
			out.print("yes");
		}else {
			out.print("no");
		}
	}
}
	
