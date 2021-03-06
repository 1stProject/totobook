package totoBook.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.service.QuestionService;
import totoBook.service.logic.NoticeServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/notice/list.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeService service = new NoticeServiceLogic();
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("member");

		session.setAttribute("member", member);

		List<Post> list = service.findAllNotice();
		request.setAttribute("NoticeList", list);
		request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request, response);
	}

}
