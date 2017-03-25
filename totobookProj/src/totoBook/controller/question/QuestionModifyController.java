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
import com.sun.org.apache.xpath.internal.operations.Mult;

import totoBook.domain.Member;
import totoBook.domain.Post;
import totoBook.service.MemberService;
import totoBook.service.QuestionService;
import totoBook.service.logic.MemberServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/modify.do")
public class QuestionModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();
		Post post = service.findQuestionById(request.getParameter("questionId"));

		request.setAttribute("question", post);
		request.getRequestDispatcher("/views/question/questionModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		QuestionService service = new QuestionServiceLogic();
		MemberService m_service = new MemberServiceLogic();
		post.setPostId(multi.getParameter("postId"));
		post.setTitle(multi.getParameter("question_title"));
		post.setContent(multi.getParameter("content"));
		if(imageAddress==null){
			post.setImageAddressPath("");
		}else{
			post.setImageAddressPath(imageAddress);
		}
		post.setImage_ext("");
		Member member1 = m_service.findMemberById(memberId);
		post.setMember(member1);

		service.modifyQuestion(post);

		request.setAttribute("question", post);
		request.getRequestDispatcher("/views/question/questionDetail.jsp").forward(request, response);
	}

}
