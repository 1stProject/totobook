package totoBook.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("memberId");
		String passwd = request.getParameter("password");
		
		 if("memberID".equals(Id) && "password".equals(passwd)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("memberId", Id);

			response.sendRedirect(request.getContextPath() + "/views/index.jsp");
			
			
		}else{

			response.sendRedirect(request.getContextPath() +"/views/member/memberList.jsp");
			
		}
	}
	}
