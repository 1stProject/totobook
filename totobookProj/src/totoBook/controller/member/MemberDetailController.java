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


@WebServlet("/member/detail.do")
public class MemberDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberServiceLogic service;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	MemberService service = new MemberServiceLogic();
	
	String id = request.getParameter("memberId");
	Member member = new Member();
	member = service.findMemberById(id);
	HttpSession session = request.getSession();
	
	Member logMember = (Member)session.getAttribute("member");
	String loginId = logMember.getMemberId();
	request.setAttribute("memberList", member);
	request.setAttribute("loginId", loginId);
	request.getRequestDispatcher("/views/member/memberDetail.jsp").forward(request, response);
}

}
