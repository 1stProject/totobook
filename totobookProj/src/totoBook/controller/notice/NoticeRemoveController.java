package totoBook.controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.service.NoticeService;
import totoBook.service.logic.NoticeServiceLogic;


@WebServlet("/notice/remove.do")
public class NoticeRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeServiceLogic();
		
		service.removeNotice(request.getParameter("noticeId"));
		
		response.sendRedirect("/views/notice/noticeList.jsp");
	}

	

}
