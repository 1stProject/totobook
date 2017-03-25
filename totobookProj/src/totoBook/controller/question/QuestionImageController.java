package totoBook.controller.question;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.service.logic.QuestionServiceLogic;

@WebServlet("/question/image.do")
public class QuestionImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionService service = new QuestionServiceLogic();
		Post post = service.findQuestionById(request.getParameter("imageId"));
		String imagead = post.getImageAddressPath();

		String fileName = null;
		InputStream in = null;
		if (post.getImageAddressPath() != null) {
			ServletContext cxt = getServletContext();
			String dir = cxt.getRealPath("/upload/product/");
			fileName = dir + "/" + imagead;
			in = new BufferedInputStream(new FileInputStream(fileName));

		}
		OutputStream out = response.getOutputStream();

		byte[] buf = new byte[8096];
		int readByte = 0;
		while ((readByte = in.read(buf)) > -1) {
			out.write(buf, 0, readByte);
		}

		in.close();
		out.close();
	}
}
