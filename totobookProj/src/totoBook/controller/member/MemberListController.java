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

@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberService service = new MemberServiceLogic();
		
		List<Member> list =service.findAllMembers();
		
		request.setAttribute("memberList", list);
		
		request.getRequestDispatcher("/views/member/memberList.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceLogic();

		if(request.getParameter("slist").equals("name") ){
			String name = request.getParameter("search");
			List<Member> list = service.findMembersByName(name);
			request.setAttribute("memberList", list);
		}else if(request.getParameter("slist").equals("phone")){
			String Tel = request.getParameter("search");
			List<Member> list = service.findMembersByTel(Tel);
			request.setAttribute("memberList", list);	
		}else if(request.getParameter("slist").equals("memberId")){
			String Id = request.getParameter("search");
			Member member=service.findMemberById(Id);
			request.setAttribute("memberList", member);
		}
		
		request.getRequestDispatcher("/views/member/memberList.jsp").forward(request, response);
	
	}
}
