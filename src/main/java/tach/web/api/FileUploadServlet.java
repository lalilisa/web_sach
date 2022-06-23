package tach.web.api;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;

import javax.servlet.annotation.*;
/* The Java file upload Servlet example */

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {

	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter o=resp.getWriter();
			o.print("11");
		}
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /* Receive file uploaded to the Servlet from the HTML5 form */
    Part filePart = request.getPart("file");
    String fileName = filePart.getSubmittedFileName();
 
//    
    System.out.println(filePart);
    System.out.println(request.getHeader("t"));
//    String json=request.getParameter("array");
//    TL s=new TL();	
//    s=new Gson().fromJson(json, TL.class);
//    System.out.println(s);
    String path="C:\\Users\\maiva\\Downloads\\ProjectWeb\\WebSach\\src\\main\\webapp\\static\\anhtruyen";
    for (Part part : request.getParts()) {
      part.write(path+"/" + fileName);
    }

    response.getWriter().print("The file uploaded sucessfully.");
  }

}