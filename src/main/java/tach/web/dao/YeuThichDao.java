/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tach.web.connect.ConnectDatabase;
import tach.web.model.Sach;
import tach.web.model.YeuThich;

/**
 *
 * @author BV LAPTOP
 */
public class YeuThichDao extends ConnectDatabase{
    Connection cnn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public List<Sach> getSachYeuThich(int s){
        List<Sach> dsSachYeuThich = new ArrayList<>();
        try {
            String query = "select s.tenKhongDau, s.id_sach,s.ten_sach,s.mo_ta,s.so_trang,s.tac_gia,s.ngay_dang,s.img from dbo.Sach s inner join dbo.YeuThich yth ON s.id_sach=yth.id_sach where yth.id_user="+s;
        
            
            ps=this.conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
            	Sach sach=new Sach(rs.getInt("id_sach"),rs.getString("ten_sach"),rs.getString("tenKhongDau"),rs.getString("mo_ta"),
                        rs.getString("tac_gia"),rs.getInt("so_trang"),
                        rs.getDate("ngay_dang").toString(),rs.getString("img"));
                dsSachYeuThich.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSachYeuThich;
    }
    
    public void deleteYeuThich(YeuThich yth){
        try {
            String query = "delete from dbo.YeuThich where id_sach="+yth.getID_Sach()+"and id_user="+yth.getID_User();
            ConnectDatabase cnb = new ConnectDatabase();
            cnn=this.conn;
            ps=cnn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertYeuThich(YeuThich yth){
        try {
        	System.out.println(yth);
            String query = "insert into dbo.YeuThich (id_sach,id_user) values (" + yth.getID_Sach() + "," +yth.getID_User()+ ")";
            ConnectDatabase cnb = new ConnectDatabase();
            cnn=this.conn;
            ps=cnn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkYeuThich(int id_user,int id_sach) {
        try {
            String query = "select * from YeuThich where id_sach=? and id_user=?";
            
            ConnectDatabase cnb = new ConnectDatabase();
            cnn=this.conn;
            ps=cnn.prepareStatement(query);
            ps.setInt(1, id_sach);
            ps.setInt(2, id_user);
            rs=ps.executeQuery();
            if(rs.next()) {
            	return true;
            }
            else {
            	return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return false;
    }
    public List<Sach> TopYeuThich(){
    	try {
			String sql="  select top(5) Sach.id_sach,Sach.ten_sach,Sach.ten_sach,Sach.so_trang,Sach.mo_ta,Sach.tac_gia,Sach.ngay_dang,Sach.img,ts.luot_yeu_thich from Sach inner join (select Sach.id_sach,count(Sach.id_sach) as 'luot_yeu_thich'  from Sach inner join YeuThich on YeuThich.id_sach=Sach.id_sach GROUP BY Sach.id_sach) as ts on Sach.id_sach=ts.id_sach Order by ts.luot_yeu_thich DESC";
			ps=this.conn.prepareStatement(sql);
			ps.executeQuery();
			rs=ps.executeQuery();
			List<Sach> danhsachTopYt=new ArrayList<>();
			while(rs.next()) {
                Sach s1=new Sach();
                s1.setID_Sach(rs.getInt("id_sach"));
                s1.setTenSach(rs.getString("ten_sach"));
                s1.setMota(rs.getString("mo_ta"));
                s1.setSoTrang(rs.getInt("so_trang"));
                s1.setTacGia(rs.getString("tac_gia"));
                s1.setNgayDang(rs.getString("ngay_dang"));
                s1.setImg(rs.getString("img"));
                
                danhsachTopYt.add(s1);
			}
			return danhsachTopYt;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
    }
    public static void main(String arsg[]) {
    	
    	YeuThichDao s=new YeuThichDao();
    	List<Sach> ss=s.TopYeuThich();
    	for(Sach i:ss)
    		System.out.println(i);
    
    }
}
