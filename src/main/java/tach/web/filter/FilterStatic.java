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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tach.web.dao.UserDao;
import tach.web.jwt.Token;
import tach.web.model.User;

public class FilterStatic implements Filter{
	
	private ServletContext context;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
	
		if (path.startsWith("/WebSach/static")) {
		    chain.doFilter(request, response); // Goes to default servlet.
		} else {
			System.out.print(path);
		    request.getRequestDispatcher("/pages" + path).forward(request, response);
		}
	}

	public void destroy() {
		
	}
	
	

}
