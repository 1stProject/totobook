package totoBook.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		MemberService service = new MemberServiceLogic();

		String password = request.getParameter("password");
		boolean result;
		result = service.checkId(password);

		PrintWriter out = response.getWriter();

		if (result == true) {

			out.print("no");

		} else {
			out.print("yes");
		}

	}
	}


