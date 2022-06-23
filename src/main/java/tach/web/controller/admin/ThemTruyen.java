package tach.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tach.web.dao.TheLoaiDao;


@WebServlet("/admin/themtruyen")
public class ThemTruyen extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TheLoaiDao theLoaiQuery=new TheLoaiDao();
		req.setAttribute("danhSachTheLoai", theLoaiQuery.danhSachTheLoai());
		req.getServletContext().getRequestDispatcher("/WEB-INF/View/ThemTruyen.jsp").forward(req,resp);
	}
}
