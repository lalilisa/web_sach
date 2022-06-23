package tach.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;



import tach.web.connect.ConnectDatabase;
import tach.web.model.User;

public class UserDao extends ConnectDatabase{
	private PreparedStatement ppst=null;
	private ResultSet rs = null;
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public int layIdTuUsername(String username) {
		try {
			ppst=this.conn.prepareStatement("select * from Users where username=?");
			ppst.setString(1, username);
			rs=ppst.executeQuery();
			User user = new User();
			while(rs.next()) {
				user = new User(rs.getInt("id_user"), 
									rs.getString("username"), 
									rs.getString("pass"),
									rs.getString("ho_ten"),
									rs.getString("email"),
									null,
									rs.getInt("vai_tro"));
				
			}
			return user.getID_User();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public List<User> tatCaTaiKhoan(){
		try {
			ppst = this.conn.prepareStatement("select * from Users");
			rs=ppst.executeQuery();
			List<User> listUsers = new ArrayList<>();
			while(rs.next()) {
				
				User user = new User(rs.getInt("id_user"), 
									rs.getString("username"), 
									rs.getString("pass"),
									rs.getString("ho_ten"),
									rs.getString("email"),
									null,
									rs.getInt("vai_tro"));
				listUsers.add(user);
			}
			ppst.close();
			return listUsers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public User layTaiKhoanBangTenDanhNhap(String username) {
		try {
			ppst = this.conn.prepareStatement("select * from Users where username = ?");
			ppst.setString(1, username);
			rs=ppst.executeQuery();
			User user = new User();
			while(rs.next()) {
				user = new User(rs.getInt("id_user"), 
									rs.getString("username"), 
									rs.getString("pass"),
									rs.getString("ho_ten"),
									rs.getString("email"),
									null,
									rs.getInt("vai_tro"));
				
			}
			
			ppst.close();
			return user;
					
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public User layTaiKhoanBangIdUser(int id) {
		try {
			ppst = this.conn.prepareStatement("select * from Users where id_user = ?");
			ppst.setInt(1, id);
			rs=ppst.executeQuery();
			User user = new User();
			while(rs.next()) {
				user = new User(rs.getInt("id_user"), 
									rs.getString("username"), 
									rs.getString("pass"),
									rs.getString("ho_ten"),
									rs.getString("email"),
									null,
									rs.getInt("vai_tro"));
				
			}
			
			ppst.close();
			return user;
					
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean themTaiKhoanAdmin(User user) {
		try {
			String encodePass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			ppst=this.conn.prepareStatement("insert into Users(username,ho_ten,vai_tro,email,pass) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ppst.setString(1, user.getUsername());
			ppst.setString(2, user.getHoTen());
			ppst.setInt(3, user.getRole());
			ppst.setString(4, user.getEmail());

			ppst.setString(5, encodePass);
			
			ppst.executeUpdate();
			ResultSet resultSet = ppst.getGeneratedKeys();
			if(resultSet.next()) {
				System.out.println(resultSet.getLong(1));
			}
			
			System.out.println("Thanh cong");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean suaUserDanhChoUser(User user) {
		try {
			ppst=this.conn.prepareStatement("update Users set ho_ten=?, email=? where username=?");
			
			ppst.setString(1, user.getHoTen());
			ppst.setString(2, user.getEmail());
			ppst.setString(3, user.getUsername());
			ppst.executeUpdate();
			
			System.out.println("Thanh cong");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean suaUserDanhChoAdmin(User user) {
		try {
			String encodePass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			ppst=this.conn.prepareStatement("update Users set ho_ten=?, email=?, pass=?, vai_tro=? where username=?");
			ppst.setString(1, user.getHoTen());
			ppst.setString(2, user.getEmail());
		
			ppst.setString(3, encodePass);
			ppst.setInt(4, user.getRole());
			ppst.setString(5, user.getUsername());
			ppst.executeUpdate();
			
			System.out.println("Thanh cong");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean xoaUser(String username) {
		try {
			ppst=this.conn.prepareStatement("delete from Users where username =?");
			ppst.setString(1, username);
			ppst.executeUpdate();
			
			System.out.println("Thanh cong");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	public void themTaiKhoan(User user) {
		String sql = "insert into Users(username, email, pass, vai_tro) values (?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			String encodePass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			st.setString(1, user.getUsername());
			st.setString(2, user.getEmail());
			st.setString(3, encodePass);
			st.setInt(4, 1);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void capNhatMatKhau(String username, String pass) {
		String sql = "update Users set pass=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			String encodePass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
			st.setString(1, encodePass);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User layTaiKhoanBangUsername(String username) {
		String sql = "select * from Users where username=?";
		try {
			User user = new User();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setID_User(rs.getInt("id_user"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass"));
				user.setImg(null);
				user.setEmail(rs.getString("email"));
				user.setHoTen(rs.getNString("ho_ten"));
				user.setRole(rs.getInt("vai_tro"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
