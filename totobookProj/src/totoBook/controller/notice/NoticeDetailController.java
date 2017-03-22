package totoBook.controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.service.logic.NoticeServiceLogic;

@WebServlet("/notice/detail.do")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		NoticeService service = new NoticeServiceLogic();
		post = service.findNoticeById(request.getParameter("noticeId"));
		
		request.setAttribute("notice", post);
		request.getRequestDispatcher("/views/notice/noticeDetail.jsp").forward(request, response);
	}

}
