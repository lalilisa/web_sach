package tach.web.controller.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/doctruyen/*"})
public class NoiDungTrangSach extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html;charset=UTF-8");
//		 resp.setCharacterEncoding("UTF-8");
		String []duongdan=req.getPathInfo().substring(1).split("/");
		if(duongdan.length==2)
			req.getServletContext().getRequestDispatcher("/WEB-INF/View/doctruyen.jsp").forward(req, resp);
		if(duongdan.length==1)
			req.getServletContext().getRequestDispatcher("/WEB-INF/View/motatruyen.jsp").forward(req, resp);
	}
	
}
