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
@WebServlet("/member/pwCheck.do")
public class PwCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberServiceLogic service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberService service = new MemberServiceLogic();
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		//Member member = service.findMemberById(memberId);
		
		PrintWriter out = response.getWriter();
		if (member.getPassword().equals(request.getParameter("password"))) {
			out.print("yes");
		} else {
			out.print("no");
		}

	}
}
