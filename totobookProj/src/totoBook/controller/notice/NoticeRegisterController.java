package totoBook.controller.notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import totoBook.domain.Member;
import totoBook.domain.Post;
import totoBook.service.MemberService;
import totoBook.service.NoticeService;
import totoBook.service.QuestionService;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.NoticeServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/notice/register.do")
public class NoticeRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("등록");
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("member");
		String memberId = member.getMemberId();
		System.out.println(memberId);
		int maxPostSize = 10 * 1024 * 1024;
		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");
		String imageAddress = multi.getFilesystemName("file1");
		System.out.println(imageAddress);
		Post post = new Post();
		NoticeService service = new NoticeServiceLogic();
		MemberService m_service = new MemberServiceLogic();

		post.setTitle(multi.getParameter("notice_title"));
		post.setContent(multi.getParameter("content"));
		post.setImageAddressPath(imageAddress);
		post.setImage_ext("");
		Member member1 = m_service.findMemberById(memberId);
		post.setMember(member1);
		service.registerNotice(post);
		response.sendRedirect(request.getContextPath() + "/notice/list.do");

	}

}
