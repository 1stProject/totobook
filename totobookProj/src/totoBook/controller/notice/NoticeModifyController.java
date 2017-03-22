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

@WebServlet("/notice/modify.do")
public class NoticeModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService service = new NoticeServiceLogic();
		Post post = service.findNoticeById(request.getParameter("noticeId"));

		request.setAttribute("notice", post);
		request.getRequestDispatcher("/views/notice/noticeModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		NoticeService service = new NoticeServiceLogic();
		post.setTitle(request.getParameter("notice_title"));
		post.setContent(request.getParameter("content"));
		post.setImageAddressPath("");
		post.setImage_ext("");
		// post.setMember("");

		service.modifyNotice(post);

		request.setAttribute("noticeId", post.getPostId());
		request.getRequestDispatcher("NoticeDetail.do").forward(request, response);
	}

}
