package totoBook.controller.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Servlet implementation class PageUploader
 */
@WebServlet("/book/pageUpload.do")
public class PageUploader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String[] binaryDataList = request.getParameterValues("imgSrc");
		// String binaryData = request.getParameter("imgInput");
		int pageNum = Integer.parseInt(request.getParameter("curPage"));
		String bookId = request.getParameter("bookId");

		System.out.println("페이지수" + pageNum);
//		System.out.println("갯수"+binaryDataList.length);

		PrintWriter out = response.getWriter();

//		for (String binaryData : binaryDataList) {
//		String binaryData = binaryDataList[pageNum];
		String binaryData = request.getParameter("imgSrc"+pageNum);
			FileOutputStream stream = null;

			if (binaryData == null || binaryData == "") {
				out.print("no");
			} else {
				try {
					binaryData = binaryData.replaceAll("data:image/png;base64,", "");
					byte[] file = Base64.decodeBase64(binaryData);
					System.out.println("file :::::::: " + file + " || " + file.length);
					String fileName = bookId + "_page" + pageNum;

					ServletContext cxt = getServletContext();
					String dir = cxt.getRealPath("/upload/book/");
					stream = new FileOutputStream(dir+ fileName + ".png");
					stream.write(file);
					stream.close();
					System.out.println(dir+ fileName + ".png"+"//파일 작성 완료");

					out.print(dir+ fileName + ".png");
					stream.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일이 정상적으로 넘어오지 않았습니다");
					out.print("no");
				} 
			}

	}
}
