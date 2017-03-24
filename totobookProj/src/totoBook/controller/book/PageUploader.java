package totoBook.controller.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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

		/*
		 * // String path = getServletContext().getRealPath("files"); String
		 * path = "C:/Users/kosta/rure"; DiskFileItemFactory factory = new
		 * DiskFileItemFactory(); ServletFileUpload upload = new
		 * ServletFileUpload(factory);
		 * 
		 * try { List<FileItem> list = upload.parseRequest(request);
		 * 
		 * Iterator iterator = list.iterator(); while (iterator.hasNext()) {
		 * System.out.println("흡"); FileItem fItem = (FileItem) iterator.next();
		 * 
		 * if (!(fItem.isFormField())) { System.out.println("여기가 아닌가"); String
		 * fileName = fItem.getName(); if ((fileName != null) &&
		 * (!fileName.equals(""))) { fileName = (new File(fileName)).getName();
		 * fItem.write(new File(path + "/" + fileName)); } } } } catch
		 * (FileUploadException e) { e.printStackTrace(); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		String binaryData = request.getParameter("imgSrc");
		FileOutputStream stream = null;
		PrintWriter out = response.getWriter();
		try {
			System.out.println("binary file " + binaryData);
			if (binaryData == null || binaryData == "") {
				throw new Exception();
			}
			binaryData = binaryData.replaceAll("data:image/png;base64,", "");
			byte[] file = Base64.decodeBase64(binaryData);
			System.out.println("file :::::::: " + file + " || " + file.length);
			String fileName = request.getParameter("bookId")+"_";
			stream = new FileOutputStream("C:/Users/kosta/rure/" + fileName + ".png");
			stream.write(file);
			stream.close();
			System.out.println("파일 작성 완료");
			
			out.print("yes");
		} catch (Exception e) {
			System.out.println("파일이 정상적으로 넘어오지 않았습니다");
			out.print("no");
		} finally {
			stream.close();
		}
	}

}
