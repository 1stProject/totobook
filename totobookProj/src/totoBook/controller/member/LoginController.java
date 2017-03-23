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
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceLogic service;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceLogic();
		
		String memberId = request.getParameter("memberId");
		String passwd = request.getParameter("password");
		boolean member1;
		member1 = service.findMember(member);
		
		 if("id".equals(member) && "password".equals(passwd)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member);

			response.sendRedirect( "/views/member/memberList.jsp");
			
			
		}else{

			response.sendRedirect("/views/member/login.jsp");
			
		}
	}
	}
