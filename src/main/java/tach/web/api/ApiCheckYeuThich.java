package tach.web.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tach.web.dao.SachDao;
import tach.web.dao.UserDao;
import tach.web.dao.YeuThichDao;
import tach.web.jwt.Token;
import tach.web.model.Sach;
import tach.web.model.User;

@WebServlet("/api/checktruyenyeuthich")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ApiCheckYeuThich extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter o=resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		try {
		String s=req.getParameter("ten_sach_khong_dau");
		SachDao querySach=new SachDao();
		UserDao queryUser=new UserDao();
		Cookie [] cookies=req.getCookies();
		String token="";
		for(Cookie i: cookies ) {
			if(i.getName().equals("token")) {
				token=i.getValue();
				break;
			}
		}
		
		Token jwt=new Token();
		String username=jwt.getUserNameFromJwtToken(token);
		User user=queryUser.layTaiKhoanBangUsername(username);
		int id_sach=querySach.getSachByTenKhongDau(s).getID_Sach();
		YeuThichDao ytquery=new YeuThichDao();
		boolean checkyt=ytquery.checkYeuThich(user.getID_User(), id_sach);
	
		if(checkyt)
			o.print("yêu thích");
		else {
			o.print("chưa yêu thích");
		}	
		
		}
		catch (Exception e) {
			System.out.println(e);
			o.print("chưa yêu thích");
		}
	}
}
