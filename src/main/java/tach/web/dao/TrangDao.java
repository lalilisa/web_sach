package tach.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tach.web.connect.ConnectDatabase;
import tach.web.model.Trang;
import tach.web.model.TrangSach;

public class TrangDao extends ConnectDatabase{
	
	
	public List<TrangSach> danhSachTrangSach(String tenSachKhonDau){
		List<TrangSach> danhSachTrang=new ArrayList<>();
		try {
			PreparedStatement ppst=this.conn.prepareStatement(" select Sach.ten_sach,Sach.tenKhongDau,Sach.tac_gia,Sach.so_trang,TrangSach.trang,TrangSach.noi_dung from Sach inner join TrangSach on Sach.id_sach=TrangSach.id_sach where Sach.tenKhongDau=?");
			ppst.setString(1,tenSachKhonDau);
			ResultSet rs=ppst.executeQuery();
			while(rs.next()) {
				TrangSach trangSach=new TrangSach(rs.getString("tenKhongDau"),rs.getInt("trang"),rs.getString("noi_dung"));
				danhSachTrang.add(trangSach);
			}
			return danhSachTrang;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	public TrangSach getTrangSach(String tenSachKhonDau,int trang){

		try {
			PreparedStatement ppst=this.conn.prepareStatement(" select Sach.ten_sach,Sach.tenKhongDau,Sach.tac_gia,Sach.so_trang,TrangSach.trang,TrangSach.noi_dung from Sach inner join TrangSach on Sach.id_sach=TrangSach.id_sach where Sach.tenKhongDau=? and TrangSach.trang=?");
			ppst.setString(1,tenSachKhonDau);
			ppst.setInt(2, trang);
			ResultSet rs=ppst.executeQuery();
			TrangSach trangSach=new TrangSach();
			while(rs.next()) {
			 trangSach=new TrangSach(rs.getString("tenKhongDau"),rs.getInt("trang"),rs.getString("noi_dung"));

			}

			return trangSach;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	
	public boolean postTrangSach(TrangSach trangSach) {
		
		try {
			PreparedStatement ppst=this.conn.prepareStatement("select * from Sach Where tenKhongDau=?");
			ppst.setString(1, trangSach.getTenSachKhongDau());
			ResultSet rs=ppst.executeQuery();
			int id_sach=0;
			if(rs.next()) {
				id_sach=rs.getInt("id_sach");
				ppst=this.conn.prepareStatement("insert into TrangSach values (?,?,?)");
				ppst.setInt(1,id_sach);
				ppst.setInt(2,trangSach.getID_Trang());
				ppst.setString(3, trangSach.getNoiDung());
				ppst.executeUpdate();
				return true;
			}

			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	public boolean suaTrangSach(TrangSach trangSach) {
		
		try {
			
			PreparedStatement ppst=this.conn.prepareStatement("select * from Sach Where tenKhongDau=?");
			ppst.setString(1, trangSach.getTenSachKhongDau().trim());
			ResultSet rs=ppst.executeQuery();
			System.out.println(trangSach);
			int id_sach=0;

			if(rs.next()) {
				id_sach=rs.getInt("id_sach");
				System.out.println(id_sach);
				ppst=this.conn.prepareStatement("update TrangSach set noi_dung=? where trang=? and id_sach=?");

				ppst.setString(1, trangSach.getNoiDung());
				ppst.setInt(2,trangSach.getID_Trang());
				ppst.setInt(3, id_sach);
				ppst.executeUpdate();
				return true;
			
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	public boolean xoaTrangSach(TrangSach trangSach) {
		
		try {
			
			PreparedStatement ppst=this.conn.prepareStatement("select * from Sach Where tenKhongDau=?");
			ppst.setString(1, trangSach.getTenSachKhongDau().trim());
			ResultSet rs=ppst.executeQuery();
			System.out.println(trangSach);
			int id_sach=0;

			if(rs.next()) {
				id_sach=rs.getInt("id_sach");
				System.out.println(id_sach);
				ppst=this.conn.prepareStatement("delete TrangSach  where trang=? and id_sach=?");
				ppst.setInt(1,trangSach.getID_Trang());
				ppst.setInt(2, id_sach);
				ppst.executeUpdate();
				return true;
			
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}


}
