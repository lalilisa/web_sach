package tach.web.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tach.web.dao.UserDao;
import tach.web.model.User;

@WebServlet(urlPatterns = {"/api-admin/user/*"})
public class ApiAdminUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/json;charset=UTF-8");
			UserDao queryUser= new UserDao();
			String params = req.getPathInfo();
			PrintWriter out = resp.getWriter();
			System.out.println(params);
			if(params.length()>1) {
				int id_user =Integer.parseInt(params.substring(1)) ;
				User user = queryUser.layTaiKhoanBangIdUser(id_user);
				
				if(user.getID_User()!=0) {
					String jsonString = new Gson().toJson(user);
					out.print(jsonString);
				}
			}else {
				List<User> listUser = queryUser.tatCaTaiKhoan();
				String jsonString = new Gson().toJson(listUser);
				out.print(jsonString);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			BufferedReader reader = req.getReader();
			getRequestBody requestBody = new getRequestBody();
			String jsonString = requestBody.getBody(reader);
			User user = new Gson().fromJson(jsonString, User.class);
			System.out.println(user);
			
			UserDao queryUser = new UserDao();
			boolean themUser = queryUser.themTaiKhoanAdmin(user);
			if(themUser) {
				out.print("Thêm thành công");
			}else {
				out.print("Thêm thất bại");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			Gson gson = new Gson();
			User user = gson.fromJson(getRequestBody.getBody(req.getReader()), User.class);
			UserDao userDao=new UserDao();
			System.out.println(user);
	
			
			boolean themUser = userDao.suaUserDanhChoAdmin(user);
			if(themUser) {
				out.print("Sua thành công");
			}else {
				out.print("Sua thất bại");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
        	String username = req.getPathInfo().substring(1);
			PrintWriter out = resp.getWriter();
			UserDao queryUser = new UserDao();
			System.out.println(username+".");
			boolean xoaUser = queryUser.xoaUser(username);
			
			if(xoaUser) {
				out.print("xoa thành công");
			}else {
				out.print("xoa thất bại");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
