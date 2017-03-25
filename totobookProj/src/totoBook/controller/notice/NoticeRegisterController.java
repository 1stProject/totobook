package totoBook.controller.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Member;
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
		System.out.println("등록");
		int maxPostSize = 10 * 1024 * 1024;
		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");
		String imageAddress = multi.getFilesystemName("file1");
		Post post = new Post();
		Member member = new Member();
		NoticeService service = new NoticeServiceLogic();

		post.setTitle(request.getParameter("notice_title"));
		post.setContent(request.getParameter("content"));
		post.setImageAddressPath(imageAddress);
		post.setImage_ext("");
		member.setMemberId("admin");

		post.setMember(member);
		service.registerNotice(post);
		response.sendRedirect(request.getContextPath() + "/notice/list.do");

	}

}
