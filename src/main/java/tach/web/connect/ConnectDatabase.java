/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.connect;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maiva
 */
public class ConnectDatabase{

    private static String dbhost = "jdbc:mysql://remotemysql.com:3306/z2LcL0DzeS";
	private static String username = "z2LcL0DzeS";
	private static String password = "kiGYBaAudE";
	protected  Connection conn=null;
    public ConnectDatabase()  {
       try { 
    	String serverName="localhost";
        String databaseName="WebDocSach";
        String user="sa";
        String password="hunterboy95";
        String port="1433";
        String dbURL=String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s", 
                serverName, port, databaseName, user, password);
//        String dbURL = String.format("jdbc:mysql://localhost:%s/databaseName=%s;user=%s;password=%s",port,databaseName,user,password);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
//        	System.out.println("Success");
//          System.out.println("Connected");
//          DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//          System.out.println("Driver name: " + dm.getDriverName());
//          System.out.println("Driver version: " + dm.getDriverVersion());
//          System.out.println("Product name: " + dm.getDatabaseProductName());
//          System.out.println("Product version: " + dm.getDatabaseProductVersion());
        }
        else{
             System.err.println("Cannot connect database, ");
        }
       } catch (Exception ex) {
         System.err.println("Cannot connect database, " + ex);
       }
//    	try  {	
//			String dbDriver = "com.mysql.cj.jdbc.Driver";
//    		Class.forName(dbDriver);
//			this.conn = DriverManager.getConnection(dbhost, username, password);
//			System.out.println("connected");	
//		} catch (Exception e) {
//			System.out.println("Cannot create database connection");
//			e.printStackTrace();
//		} finally {
//			
//		}

    }
    public static void main(String[] args) {
        ConnectDatabase s=new ConnectDatabase();
        System.out.println(s.conn);
    }

}
