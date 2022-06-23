package tach.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tach.web.dao.UserDao;
import tach.web.jwt.Token;
import tach.web.model.User;
public class AuthorizationFilter implements Filter{
	
	private ServletContext context;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		System.out.println(url);
		System.out.println(req.getContextPath());
		
		boolean checkDangNhap=false;
		boolean checkAD=false;
		Cookie[] cookies=req.getCookies();
		for(Cookie i:cookies) {
			if(i.getName().equals("username")) {
				if(i.getValue()!=null) {
					checkDangNhap=true;
				}
			}
			if(i.getName().equals("role")) {
				if(i.getValue().equals("1")) {
					checkAD=true;
				}
			}
		}
		if(url.startsWith("/WebSach/dangnhap") || url.startsWith("/WebSach/dangky") ) {
			
			if(checkDangNhap) {
				resp.sendRedirect(req.getContextPath()+"/home");
				System.out.println("danh nhap roi");
			}else {
				chain.doFilter(request, response);
				System.out.println("dang nhap di");
			}
		}else if (url.startsWith("/WebSach/admin") ){
			resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
			 
			if(checkAD) {
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect(req.getContextPath()+"/home");
			}
			
		} else if(url.startsWith("/WebSach/lichsudoc") || url.startsWith("/WebSach/truyenyeuthich") || url.startsWith("/WebSach/edit")) {
			if(checkDangNhap) {
				chain.doFilter(request, response);
				System.out.println("dang nhap roi");
			}else {
				resp.sendRedirect(req.getContextPath()+"/home");
				System.out.println("danh nhapdii");
			}
		}
		else {
			chain.doFilter(request, response);
		}
		
		
	}

	public void destroy() {
		
	}
	
	private String parseToken(HttpServletRequest req) {
		String auth = req.getHeader("Authorization");
		if (auth!=null && auth.startsWith("Bearer ")) {
			return auth.substring(7);
		}
		return null;
	}

}
