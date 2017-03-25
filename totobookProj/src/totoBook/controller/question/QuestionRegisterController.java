package totoBook.controller.question;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.sun.xml.internal.txw2.Document;

import totoBook.domain.Member;
import totoBook.domain.Photo;
import totoBook.domain.Post;
import totoBook.service.MemberService;
import totoBook.service.QuestionService;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/register.do")
public class QuestionRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// request.getContextPath()+"/views/question/questionList.jsp"

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		int maxPostSize = 10 * 1024 * 1024;
		response.setContentType("text/html; charset=UTF-8");
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload/product");
		MultipartRequest multi = new MultipartRequest(request, dir, maxPostSize, "UTF-8");
		String imageAddress = multi.getFilesystemName("file1");
		QuestionService service = new QuestionServiceLogic();
		MemberService m_service = new MemberServiceLogic();
		HttpSession session = request.getSession();
		post.setTitle(multi.getParameter("question_title"));
		post.setContent(multi.getParameter("content"));
		if (imageAddress == null) {
			post.setImageAddressPath("");
		} else {
			post.setImageAddressPath(imageAddress);
		}
		post.setImage_ext("");
		Member member = (Member) session.getAttribute("member");
		String memberId = member.getMemberId();
		System.out.println(memberId);
		post.setMember(member);

		service.registerQuestion(post);

		response.sendRedirect(request.getContextPath() + "/question/list.do");

	}

}
