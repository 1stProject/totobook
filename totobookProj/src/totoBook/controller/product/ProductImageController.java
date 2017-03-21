package totoBook.controller.product;

import java.awt.image.ImageFilter;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Photo;
import totoBook.domain.Product;
import totoBook.store.logic.ProductStoreLogic;

/**
 * Servlet implementation class ProductImageController
 */
@WebServlet("/product/image.do")
public class ProductImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		ProductStoreLogic service = new ProductStoreLogic();
		
		
		String productid = (request.getParameter("productid"));


		Product product = service.selectProductById(productid);
		Photo photo = product.getPhoto();

		String fileName = null;
		InputStream in = null;

		if (photo != null) {
			response.setContentType(((ServletRequest) photo).getContentType());
			
			ServletContext cxt = getServletContext();
			String dir = cxt.getRealPath("/upload");
			
			fileName = dir + "/" + photo.getFileName();
			
			
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