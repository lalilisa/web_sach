/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
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
import tach.web.model.YeuThich;

/**
 *
 * @author BV LAPTOP
 */
@WebServlet(urlPatterns="/api/truyenyeuthich/")
public class ApiTruyenYeuThich extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Cookie [] cookies=req.getCookies();
        String token="";
        for(Cookie i : cookies) {
        	if(i.getName().equalsIgnoreCase("token")) {
        			token=i.getValue();
        	}
        }
        
        Token s=new Token();
        String username=s.getUserNameFromJwtToken(token);
        UserDao queryUser=new UserDao();

        User user=queryUser.layTaiKhoanBangUsername(username);
        System.out.println(username);
        PrintWriter printWriter=resp.getWriter();
        
        List<Sach> ythList =new YeuThichDao().getSachYeuThich(user.getID_User());
        String jsonString = new Gson().toJson(ythList);
        printWriter.write(jsonString); 
        printWriter.close();

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        try {
            BufferedReader reader=req.getReader();
            getRequestBody request=new getRequestBody();
            String jsonString=request.getBody(reader);
            YeuThich ythThich=new Gson().fromJson(jsonString, YeuThich.class);
            System.out.println(jsonString);
            Cookie [] cookies=req.getCookies();
            String token="";
            for(Cookie i : cookies) {
            	if(i.getName().equalsIgnoreCase("token")) {
            			token=i.getValue();
            	}
            }
            System.out.println(token);
            Token s=new Token();
            String username=s.getUserNameFromJwtToken(token);
            UserDao queryUser=new UserDao();
            User user=queryUser.layTaiKhoanBangUsername(username);
            System.out.println(user);
            ythThich.setID_User(user.getID_User());
            System.out.println(username);
            YeuThichDao ythd = new YeuThichDao();
            ythd.insertYeuThich(ythThich);
            printWriter.print(jsonString);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=resp.getWriter();
        try {
            BufferedReader reader=req.getReader();
            getRequestBody request=new getRequestBody();
            String jsonString=request.getBody(reader);
            YeuThich ythThich=new Gson().fromJson(jsonString, YeuThich.class);
            System.out.println(jsonString);
            Cookie [] cookies=req.getCookies();
            String token="";
            for(Cookie i : cookies) {
            	if(i.getName().equalsIgnoreCase("token")) {
            			token=i.getValue();
            	}
            }
            System.out.println(token);
            Token s=new Token();
            String username=s.getUserNameFromJwtToken(token);
            UserDao queryUser=new UserDao();
            User user=queryUser.layTaiKhoanBangUsername(username);
            ythThich.setID_User(user.getID_User());
            System.out.println(ythThich);
            YeuThichDao ythd = new YeuThichDao();
            ythd.deleteYeuThich(ythThich);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
}
