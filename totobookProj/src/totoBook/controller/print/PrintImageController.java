package totoBook.controller.print;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Photo;
import totoBook.service.PrintService;
import totoBook.service.logic.PrintServiceLogic;

/**
 * Servlet implementation class PrintImageController
 */
@WebServlet("/print/image.do")
public class PrintImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintService printService = new PrintServiceLogic();
		Photo photo = printService.findPhotoByPhotoId(request.getParameter("photoId"));
		
		String fileName = null;
		InputStream in = null;
		ServletContext cxt = getServletContext();
		String dir = cxt.getRealPath("/upload");
		fileName = dir + "/"  + photo.getFileName();
		in = new BufferedInputStream(new FileInputStream(fileName));
		
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
