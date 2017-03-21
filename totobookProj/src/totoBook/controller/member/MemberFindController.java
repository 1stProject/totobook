package totoBook.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Member;
import totoBook.service.MemberService;
import totoBook.service.logic.MemberServiceLogic;

@WebServlet("/member/find.do")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceLogic();
		
		List<Member> list = service.findAllMembers();
		
		request.setAttribute("members", list);
		
		request.getRequestDispatcher("/views/memberList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceLogic();
		String name = request.getParameter("memberSearch");
		List<Member> list = service.findMembersByName(name);
		request.setAttribute("members", list);
		
		request.getRequestDispatcher("/views/memberList.jsp").forward(request, response);
	
	}

}
