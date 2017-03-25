package totoBook.controller.product;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Photo;
import totoBook.domain.Review;
import totoBook.service.ReviewService;
import totoBook.service.logic.ReviewServiceLogic;

/**
 * Servlet implementation class ProductReviewController
 */
@WebServlet("/product/reviewimage.do")
public class ProductReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService reviewService = new ReviewServiceLogic();

		String productId = request.getParameter("productId");

		List<Review> list = new ArrayList<>();
		list =	 reviewService.findCommentsByProduct(productId);
		Photo phto = new Photo();
		String imagead = list.get(0).getImageAddress();
		phto.setContentType(imagead);
		
		
		
		list.get(0).setPhoto(phto);
		String fileName = null;
		InputStream in = null;
		if (phto != null) {
//			response.setContentType(phto.getContentType());
			ServletContext cxt = getServletContext();
			String dir = cxt.getRealPath("/upload/review/");
			fileName = dir + "/"  + list.get(0).getImageAddress();
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
