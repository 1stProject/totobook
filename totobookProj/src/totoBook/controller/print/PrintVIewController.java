package totoBook.controller.print;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import totoBook.domain.Photo;
import totoBook.service.PrintService;
import totoBook.service.logic.PrintServiceLogic;

@WebServlet("/print/view.do")
public class PrintVIewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintService printService = new PrintServiceLogic();
		List<Photo> photos = printService.findPhotosByPrintId(request.getParameter("printId"));
		request.setAttribute("photos", photos);
		request.getRequestDispatcher("/views/print/photoList.jsp").forward(request, response);
	}
}
