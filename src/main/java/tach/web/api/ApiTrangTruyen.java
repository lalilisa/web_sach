package tach.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import tach.web.dao.TrangDao;
import tach.web.model.Sach;
import tach.web.model.ServiceModel;
import tach.web.model.TheLoai;
import tach.web.model.Trang;
import tach.web.model.TrangSach;

@WebServlet(urlPatterns = {"/api/trangtruyen/*"})
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ApiTrangTruyen extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				resp.setContentType("aplication/json;charset=UTF-8");
				try {
					String [] duLieuSach=req.getPathInfo().substring(1).split("/");
					TrangDao queryTrang=new TrangDao();
					PrintWriter o=resp.getWriter();
					for(String i:duLieuSach)
						System.out.println(i);
					if(duLieuSach.length==2 && !duLieuSach[1].equalsIgnoreCase("full")) {
						String tenSachKhongDau=duLieuSach[0];
						int trang=Integer.parseInt(duLieuSach[1]);
						TrangSach trangSach=queryTrang.getTrangSach(tenSachKhongDau, trang);
						
						List<TrangSach> l=new ArrayList<>();
						l.add(trangSach);
						String jsonString=new Gson().toJson(l);
						System.out.println(jsonString);
						o.print(jsonString);
					}
					 if (duLieuSach.length==2 && duLieuSach[1].equalsIgnoreCase("full")) {
						String tenSachKhongDau=duLieuSach[0];
						List<TrangSach> danhSachTrnag=queryTrang.danhSachTrangSach(tenSachKhongDau);

						String jsonString=new Gson().toJson(danhSachTrnag);
						o.print(jsonString);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				resp.setContentType("text/html;charset=UTF-8");
				resp.setCharacterEncoding("UTF-8");
				try {
					PrintWriter out=resp.getWriter();

					int trang=Integer.parseInt(req.getParameter("trang")) ;
					Part filePart=req.getPart("file");
					String noidungTrang=filePart.getSubmittedFileName();
		               String realPath =req.getServletContext().getRealPath("/static/img/");
		            for (Part part : req.getParts()) {
		            	 part.write(realPath+"/" + noidungTrang);
		            }
		            TrangDao queryTrang=new TrangDao();

		            String tenSachKhongDau=req.getPathInfo().substring(1);
		            TrangSach trangSach=new TrangSach(tenSachKhongDau,trang,noidungTrang);
		            boolean statusDangTrang=queryTrang.postTrangSach(trangSach); 
		            System.out.println(tenSachKhongDau);
					if(statusDangTrang)
						out.print("Đăng thành công");
					else
							out.print("Trang đã đăng");
					
				} catch (Exception e) {
					System.out.println("Tri MAi");
					System.out.println(e);
				}
		}
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");
			try {
				PrintWriter out=resp.getWriter();

				int trang=Integer.parseInt(req.getParameter("trang")) ;
				Part filePart=req.getPart("file");
				String noidungTrang=filePart.getSubmittedFileName();
	               String realPath =req.getServletContext().getRealPath("/static/img");
	            for (Part part : req.getParts()) {
	            	 part.write(realPath+"/" + noidungTrang);
	            }
	            TrangDao queryTrang=new TrangDao();

	
	            String tenSachKhongDau=req.getPathInfo().substring(1);
	            System.out.println(tenSachKhongDau);
	            TrangSach trangSach=new TrangSach(tenSachKhongDau,trang,noidungTrang);
	            boolean statusDangTrang=queryTrang.suaTrangSach(trangSach); 
	            
				if(statusDangTrang)
					out.print("Sửa thành công");
				else
						out.print("Sửa thất bại");
				
			} catch (Exception e) {
				System.out.println("Sửa thất bại");
				System.out.println(e);
			}
		}
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					resp.setContentType("application/json;charset=UTF-8");
					try {
						PrintWriter o=resp.getWriter();
						getRequestBody request=new getRequestBody();
						String jsonTrangSach=request.getBody(req.getReader());
						TrangSach trangSach=new Gson().fromJson(jsonTrangSach, TrangSach.class);
						TrangDao queryTrang=new TrangDao();
						
						boolean statusXoaTrang=queryTrang.xoaTrangSach(trangSach);
						if(statusXoaTrang)
								o.print("Xóa thành công");
						else
								o.print("Xóa thất bại");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}
		}
}
