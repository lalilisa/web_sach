package tach.web.controller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/doctuyen/a")
public class TrangTruyen extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter outPrintWriter=resp.getWriter();
		req.getServletContext().getRequestDispatcher("/WEB-INF/View/doctruyen.jsp").forward(req, resp);
	}
}
