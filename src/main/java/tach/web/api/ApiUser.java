package tach.web.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import tach.web.dao.UserDao;
import tach.web.jwt.Token;
import tach.web.model.User;

@WebServlet(urlPatterns = {"/api/user/"})
public class ApiUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/json;charset=UTF-8");
			UserDao queryUser= new UserDao();
			String params = req.getPathInfo();
			PrintWriter out = resp.getWriter();
			
			String token="";
			Cookie[] cookies = req.getCookies();
			for(Cookie i:cookies) {
				System.out.println(i.getName() + i.getValue());
				if(i.getName().equals("token")) {
					token=i.getValue();
				}
			}
			String username = Token.getUserNameFromJwtToken(token);
			System.out.println(username);
			User user = queryUser.layTaiKhoanBangTenDanhNhap(username);
			
			if(user.getID_User()!=0) {
				String jsonString = new Gson().toJson(user);
				out.print(jsonString);
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
			UserDao queryUser = new UserDao();
//			BufferedReader reader = req.getReader();
//			getRequestBody requestBody = new getRequestBody();
//			String jsonString = requestBody.getBody(reader);
//			User user = new Gson().fromJson(jsonString, User.class);
//			System.out.println(user);
			
			Gson gson = new Gson();
			User user = gson.fromJson(getRequestBody.getBody(req.getReader()), User.class);
			System.out.println(user);
			
			String token="";
			Cookie[] cookies = req.getCookies();
			for(Cookie i:cookies) {
				System.out.println(i);
				if(i.getName().equals("token")) {
					token=i.getValue();
				}
			}
			String username = Token.getUserNameFromJwtToken(token);
			System.out.println(username);
			user.setUsername(username);
			System.out.println(user);
			boolean themUser = queryUser.suaUserDanhChoUser(user);
			if(themUser) {
				out.print("Sua thành công");
			}else {
				out.print("Sua thất bại");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	
}
