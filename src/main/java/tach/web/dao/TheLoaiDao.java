package tach.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tach.web.connect.ConnectDatabase;
import tach.web.model.TheLoai;

public class TheLoaiDao extends ConnectDatabase {
		
	
	public List<TheLoai> danhSachTheLoai(){
		try {
			PreparedStatement ppst=this.conn.prepareStatement("select * from TheLoai");
			List<TheLoai> danhSachTL=new ArrayList<>();
			ResultSet re= ppst.executeQuery();
			while(re.next()) {
				TheLoai theLoai=new TheLoai ();
				theLoai.setID_TheLoai(re.getInt(1)+"");
				theLoai.setTenTheLoai(re.getString(2));
				danhSachTL.add(theLoai);
			}
			return danhSachTL;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public TheLoai layTheLoaiTheoId(int id){
		String sql = "select * from TheLoai where id_TL=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, Integer.toString(id));
			TheLoai t = new TheLoai();
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				t.setID_TheLoai(rs.getInt("id_TL")+"");
				t.setTenTheLoai(rs.getString("tenTL"));
				return t;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void themTheLoai(TheLoai tl){
		String sql = "insert into TheLoai(tenTL) values (?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, tl.getTenTheLoai());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void xoaTheLoai(int id){
		String sql = "delete from TheLoai where id_TL=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}