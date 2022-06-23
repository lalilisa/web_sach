package tach.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tach.web.dao.YeuThichDao;
import tach.web.model.Sach;


@WebServlet("/toptruyen")
public class ApiTopTruyen  extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("application/json;charset=UTF-8");
			PrintWriter o=resp.getWriter();
			
			try {
				YeuThichDao ytDao=new YeuThichDao();
				List<Sach> danhSachYeuThich=ytDao.TopYeuThich();
				String jsonString=new Gson().toJson(danhSachYeuThich);
				o.print(jsonString);
			} catch (Exception e) {
				System.out.println(e);
			}
	}

}
