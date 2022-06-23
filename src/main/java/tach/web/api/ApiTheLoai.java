package tach.web.api;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import io.jsonwebtoken.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tach.web.dao.TheLoaiDao;
import tach.web.model.TheLoai;


@WebServlet(urlPatterns = {"/api/theloai/*"},name = "api_theloai")
public class ApiTheLoai extends HttpServlet{
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            try {
                req.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Gson gson = new Gson();
            TheLoaiDao tld = new TheLoaiDao();
            List<TheLoai> list = tld.danhSachTheLoai();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String jsonString=gson.toJson(list);
            resp.getWriter().write(jsonString);
        } catch (java.io.IOException ex) {
			System.out.println(ex);
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        TheLoai tl;
		try {
			tl = gson.fromJson(getRequestBody.getBody(req.getReader()), TheLoai.class);
			TheLoaiDao tld = new TheLoaiDao();
			tld.themTheLoai(tl);
			resp.getWriter().write(gson.toJson(tl));
		} catch (JsonSyntaxException | java.io.IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		Gson gson = new Gson();
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
		int idTL = Integer.parseInt(req.getParameter("id"));
		TheLoaiDao tld = new TheLoaiDao();
		tld.xoaTheLoai(idTL);
		try {
			resp.getWriter().write(gson.toJson("Xoa thanh cong"));
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
    }
}