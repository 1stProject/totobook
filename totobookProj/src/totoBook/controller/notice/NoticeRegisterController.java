package totoBook.controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.service.QuestionService;
import totoBook.service.logic.NoticeServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/notice/register.do")
public class NoticeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		totoBook.domain.Member member = new totoBook.domain.Member();
		NoticeService service = new NoticeServiceLogic();

		post.setTitle(request.getParameter("notice_title"));
		post.setContent(request.getParameter("content"));
		post.setImageAddressPath("");
		post.setImage_ext("");
		member.setMemberId("admin");
		post.setMember(member);
		service.registerNotice(post);

		response.sendRedirect(request.getContextPath()+"/notice/list.do");

	}

}
