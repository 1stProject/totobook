package totoBook.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @version 1.0
 */
@WebServlet("/member/idCheck.do")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("memberId");
		
		PrintWriter out = response.getWriter();
		
		if(id.equals("")){
			out.println("false");
			
		}else{
			out.println("ok");
		}
	}

}
