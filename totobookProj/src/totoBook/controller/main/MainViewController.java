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
import totoBook.service.QuestionService;
import totoBook.service.logic.NoticeServiceLogic;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/main/main.do")
public class MainViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService noticeService = new NoticeServiceLogic();
		QuestionService questionService = new QuestionServiceLogic();
		
		List<Post> tempList = noticeService.findAllNotice();
		List<Post> noticeList = new ArrayList<>();
		if(tempList.size() < 4){
			for(Post post : tempList)
				noticeList.add(post);
		}
		else
			noticeList = tempList;
		request.setAttribute("noticeList", noticeList);
		
		tempList = questionService.findAllQuestion();
		List<Post> qnaList = new ArrayList<>();
		if(tempList.size() < 4){
			for(Post post : tempList)
				qnaList.add(post);
		}
		request.setAttribute("qnaList", qnaList);
		request.getRequestDispatcher("/views/main.jsp").forward(request, response);
	}
}
