package totoBook.controller.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.service.logic.NoticeServiceLogic;

@WebServlet("/main/list.do")
public class MainViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceLogic();
		
		List<Post> tempList = noticeService.findAllNotice();
		List<Post> noticeList = new ArrayList<>();
		if(tempList.size() < 5){
			for(Post post : tempList)
				noticeList.add(post);
		}
		else
			noticeList = tempList;
		request.setAttribute("noticeList", noticeList);
		System.out.println("tempList Size : " + tempList.size());
		System.out.println("noticeList Size : " + noticeList.size()) ;
				
		request.getRequestDispatcher("/views/main.jsp").forward(request, response);
	}
}
