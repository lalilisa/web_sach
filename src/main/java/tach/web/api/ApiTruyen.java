/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import org.apache.jasper.tagplugins.jstl.core.Out;

import tach.web.dao.SachDao;
import tach.web.model.Sach;
import tach.web.model.TheLoai;
import tach.web.model.TheLoaiSach;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author maiva
 */
@WebServlet(urlPatterns = {"/api/sach/*"},name = "api_sach")

@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ApiTruyen extends  HttpServlet{

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
                    resp.setContentType("application/json;charset=UTF-8");
                    SachDao querySach=new SachDao();
                    String params=req.getPathInfo();
                    PrintWriter out=resp.getWriter();
                    System.out.println(params.length());
                    if(params.length()>1){
                    	String ten=params.substring(1);

                       if(ten.matches("\\d+")) {
                           int id_sach=Integer.parseInt(params.substring(1));
                           Sach sach =querySach.getSachByID(id_sach);
                           System.out.println(sach);
                           if(sach.getID_Sach()!=0){
                                String jsonString=new Gson().toJson(sach);

                                out.print(jsonString);
                           }
                       }
                       else {
                    	   Sach sach=querySach.getSachByTenKhongDau(ten);
                           String jsonString=new Gson().toJson(sach);
                           out.print(jsonString);
					}

                    }
                    else{
                        List<Sach> listSach=querySach.getAllSach();
                        String jsonString=new Gson().toJson(listSach);
                        out.print(jsonString);
                    }
                    
        } catch (Exception e) {
                System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
    		resp.setContentType("text/html;charset=UTF-8");
            req.setCharacterEncoding("UTF-8");
            PrintWriter o=resp.getWriter();
            try {
               String tenSach=req.getParameter("ten_truyen");
               
               String tacGia=req.getParameter("tac_gia");
               
               String mota=req.getParameter("mo_ta");
               
               int soTrang=Integer.parseInt(req.getParameter("so_trang"));
               
               Part filePart = req.getPart("file");
               
               String fileName = filePart.getSubmittedFileName();
               
               String theLoaiSach=req.getParameter("theloaisach");
               System.out.println(theLoaiSach);
    		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    		   LocalDateTime now = LocalDateTime.now(); 
    		   if (fileName==null) {
    			   
    			   fileName="sss";
    		   }
    		   String ngayDang=dtf.format(now);
    		   Sach sach=new Sach(0,tenSach,new coDauSangKoDau().ChuanHoa(tenSach),mota,tacGia
    				   	,soTrang,ngayDang,fileName);
    		   System.out.println(sach);
              ObjectMapper mapper=new ObjectMapper();
              List<TheLoai> listTheLoai=Arrays.asList(mapper.readValue(theLoaiSach,TheLoai[].class));
            for(TheLoai i: listTheLoai)
            	System.out.println(i);
               String realPath =req.getServletContext().getRealPath("/static/img/");
            for (Part part : req.getParts()) {
            	 part.write(realPath+"/" + fileName);
            }
                       SachDao querySach=new SachDao();
    
                 boolean statusDangTruyen=querySach.dangSach(sach, listTheLoai);
                 if(statusDangTruyen)
                	 o.print("Đăng Thành Công");
                 else {
                	 o.print("Đăng Thất Bại");
   			}

            } catch(Exception e) {
                o.write("trimaitb");
                System.out.println(e);
            }
}
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("UTF-8");
        PrintWriter o=resp.getWriter();
        try {
           String tenSach=req.getParameter("ten_truyen");
           System.out.println(tenSach);
           String tacGia=req.getParameter("tac_gia");
           
           String mota=req.getParameter("mo_ta");
           
           int soTrang=Integer.parseInt(req.getParameter("so_trang"));
           
           Part filePart = req.getPart("file");
           
           String fileName = filePart.getSubmittedFileName();
           
           String theLoaiSach=req.getParameter("theloaisach");
           
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now(); 
		   
		   String ngayDang=dtf.format(now);
		   Sach sach=new Sach(0,tenSach,new coDauSangKoDau().ChuanHoa(tenSach),mota,tacGia
				   	,soTrang,ngayDang,fileName);
		   System.out.println(sach);
		
		
          ObjectMapper mapper=new ObjectMapper();
          List<TheLoai> listTheLoai=Arrays.asList(mapper.readValue(theLoaiSach,TheLoai[].class));
        for(TheLoai i: listTheLoai)
        	System.out.println(i);
  
           String realPath =req.getServletContext().getRealPath("/static/img");
        for (Part part : req.getParts()) {
        	 part.write(realPath+"/" + fileName);
        }
                   SachDao querySach=new SachDao();
             String tenSachKhongDau=req.getPathInfo().substring(1);
             System.out.println(tenSachKhongDau);
             boolean statusDangTruyen=querySach.suaTruyen(tenSachKhongDau,sach, listTheLoai);
             if(statusDangTruyen)
            	 o.print("SửaThành Công");
             else {
            	 o.print("Sửa Thất Bại");
			}

        } catch(Exception e) {
            o.write("trimaitb");
            System.out.println(e);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("application/json;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
    	try {
    		PrintWriter out=resp.getWriter();
    	  	int id_sach=Integer.parseInt(req.getPathInfo().substring(1)); 
    	  	SachDao querySach=new SachDao();
    	  	boolean statusXoaTruyen = querySach.xoaTruyen(id_sach);
    	  	if(statusXoaTruyen) {
    	  		out.print("Xóa Thành Công");
    	  		System.out.println("TCCTCTC");
    	  	}
    	  	else {
        	  	out.print("Xóa Thất bại");
			}
		} catch (Exception e) {
			System.out.println(e);
    		PrintWriter out=resp.getWriter();
    	  	out.print("Xóa Thất bại");
		}
  
    }
}