package tach.web.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import tach.web.api.coDauSangKoDau;
import tach.web.connect.ConnectDatabase;
import tach.web.model.Sach;
import tach.web.model.TheLoai;


public class SachDao extends ConnectDatabase{
        private PreparedStatement ppst=null;
        private ResultSet rs=null;

     
        
        public List<Sach> getAllSach(){
            try {
       
                ppst =this.conn.prepareStatement("select * from Sach");
                rs=ppst.executeQuery();
                List<Sach> listSach=new ArrayList<>();
                while(rs.next()){
                Integer id_sach=rs.getInt("id_sach");
                Sach sach=new Sach(rs.getInt("id_sach"),rs.getString("ten_sach"),rs.getString("tenKhongDau"),rs.getString("mo_ta"),
                                    rs.getString("tac_gia"),rs.getInt("so_trang"),
                                    rs.getDate("ngay_dang").toString(),rs.getString("img"));
                PreparedStatement ppstTheLoai=this.conn.prepareStatement("select * from TheLoai where id_TL in ( select id_TL from Sach inner join TheLoaiSach on Sach.id_sach=TheLoaiSach.id_sach where Sach.id_sach=?)");
                ppstTheLoai.setInt(1, id_sach);
                ResultSet rsTL=ppstTheLoai.executeQuery();
                List<TheLoai> tlSach=new ArrayList<>();
                while(rsTL.next()) {
                    TheLoai tl=new TheLoai();
                    tl.setID_TheLoai(rsTL.getInt(1)+"");
                    tl.setTenTheLoai(rsTL.getString(2));
                    sach.getTheLoaiSach().add(tl);

                }
                
                listSach.add(sach);
                }
       		 	ppst.close();
                return listSach;
            } catch (Exception e) {
                
                System.out.println(e);
                return null;
            }
           
        }
                public Sach getSachByID(int ID_Sach){
            try {
                ppst =this.conn.prepareStatement("select * from Sach Where id_sach=?");
                ppst.setString(1, ID_Sach+"");
                rs=ppst.executeQuery();
                Sach sach=new Sach();
                while(rs.next()){
                 sach=new Sach(rs.getInt("id_sach"),rs.getString("ten_sach"),rs.getString("tenKhongDau"),rs.getString("mo_ta"),
                                    rs.getString("tac_gia"),rs.getInt("so_trang"),
                                    rs.getDate("ngay_dang").toString(),rs.getString("img"));
            }
       		 	ppst.close();
                return sach;
            } catch (Exception e) {
                
                System.out.println(e);
                return null;
            }
           
        }
                
                public Sach getSachByTenKhongDau(String tenKhongDau){
            try {
                ppst =this.conn.prepareStatement("select * from Sach Where tenKhongDau=?");
                ppst.setString(1, tenKhongDau);
                rs=ppst.executeQuery();
                Sach sach=new Sach();
                while(rs.next()){
                 sach=new Sach(rs.getInt("id_sach"),rs.getString("ten_sach"),rs.getString("tenKhongDau"),rs.getString("mo_ta"),
                                    rs.getString("tac_gia"),rs.getInt("so_trang"),
                                    rs.getDate("ngay_dang").toString(),rs.getString("img"));
            }
                ppst=this.conn.prepareStatement("  select * from TheLoai where id_TL in ( select id_TL from Sach inner join TheLoaiSach on Sach.id_sach=TheLoaiSach.id_sach where tenKhongDau=?)");
                ppst.setString(1, tenKhongDau);
                rs=ppst.executeQuery();
                List<TheLoai> tL=new ArrayList<>(); 
                while(rs.next()){
                    TheLoai tl=new TheLoai();
                    tl.setID_TheLoai(rs.getInt(1)+"");
                    tl.setTenTheLoai(rs.getString(2));
                    tL.add(tl);
               }
                sach.setTheLoaiSach(tL);
                ppst.close();
                return sach;
            } catch (Exception e) {
                
                System.out.println(e);
                return null;
            }
           
        }
         public boolean dangSach(Sach sach,List<TheLoai> listTheLoai) {
        	 try {

        		 ppst=this.conn.prepareStatement("insert into Sach (ten_sach,tenKhongDau,mo_ta,so_trang,tac_gia,ngay_dang,img) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        		 ppst.setString(1,sach.getTenSach());
        		 ppst.setString(2,new coDauSangKoDau().ChuanHoa(sach.getTenSach()));
        		 ppst.setString(3, sach.getMota());
        		 ppst.setInt(4, sach.getSoTrang());
        		 ppst.setString(5, sach.getTacGia());
        		 ppst.setDate(6, Date.valueOf(sach.getNgayDang()));
        		 ppst.setString(7, sach.getImg());
        		 ppst.executeUpdate();
        		 ResultSet resultSet=ppst.getGeneratedKeys();

        		 if(resultSet.next()) {
        			 System.out.println(resultSet.getLong(1));
        			 int id_sach=resultSet.getInt(1);
        			 dangTheLoaiSach(id_sach,listTheLoai);
        		 }
        		 System.out.println("Thanh Cong");
        		 return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
        	 
        	 
         }
         public void dangTheLoaiSach(int id_sach,List<TheLoai> listTheLoai) {
        	 try {
        		 ppst=this.conn.prepareStatement("delete TheLoaiSach where id_sach=?");
        		 ppst.setInt(1, id_sach);
        		 ppst.executeUpdate();
        		 ppst.close();
        		 ppst=this.conn.prepareStatement("insert into TheLoaiSach values (?,?)");
        		 for(TheLoai tl:listTheLoai ) {
        			 ppst.setInt(1, id_sach);
        			 ppst.setInt(2,Integer.parseInt(tl.getID_TheLoai()));
        			 ppst.addBatch();
        		 };
        		 ppst.executeBatch();
        		 ppst.close();
			} catch (Exception e) {
					System.out.println(e);
				// TODO: handle exception
			}
        	 
         }
         public boolean suaTruyen(String tenSach,Sach sach,List<TheLoai> listTheLoai) {
        	 try {
        		 System.out.println(sach);
        		 Sach sachs=getSachByTenKhongDau(tenSach);
        		 System.out.println(sachs.getID_Sach());
        		 ppst=this.conn.prepareStatement("update Sach set ten_sach=?,tenKhongDau=?, mo_ta=?, img=?,so_trang=?,tac_gia=?,ngay_dang=? where id_sach=?");
				// ppst=this.conn.prepareStatement("update Sach set ten_sach=?,tenKhongDau=?,mo_ta=?,so_trang=?,tac_gia=?,ngay_dang=?,img=? where id_sach=?");
	       		 ppst.setString(1,sach.getTenSach());
	       		 ppst.setString(2,sach.getTenKhongDau());
	       		 ppst.setString(3,sach.getMota());
	       		 ppst.setString(4, sach.getImg());
	       		 ppst.setInt(5, sach.getSoTrang());
	       		 ppst.setString(6, sach.getTacGia());
	       		 ppst.setDate(7, Date.valueOf(sach.getNgayDang()));
//	       		 ppst.setString(3, sach.getMota());
//	       		 ppst.setInt(4, sach.getSoTrang());
//	       		 ppst.setString(5, sach.getTacGia());
//	       		 ppst.setDate(6, Date.valueOf(sach.getNgayDang()));
//	       		 ppst.setString(7, sach.getImg());
	       		 ppst.setInt(8, sachs.getID_Sach());
	       		 ppst.executeUpdate();

    			 //dangTheLoaiSach(sachs.getID_Sach(),listTheLoai);
    			 System.out.println("Thanh Cong");
    			 return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
        	 
         }
         public boolean xoaTruyen(int id_sach) {
        	 try {
				ppst=this.conn.prepareStatement("delete Sach where id_sach=?");
				ppst.setInt(1, id_sach);
				ppst.executeUpdate();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
        	 
         }
         public int layIdTuTenKhongDau(String tenKhongDau) {
     		try {
     			ppst=this.conn.prepareStatement("select * from Sach where tenKhongDau=?");
     			ppst.setString(1, tenKhongDau);
     			rs=ppst.executeQuery();
     			Sach sach = new Sach();
     			while(rs.next()){
                     sach=new Sach(rs.getInt("id_sach"),rs.getString("ten_sach"),rs.getString("tenKhongDau"),rs.getString("mo_ta"),
                                        rs.getString("tac_gia"),rs.getInt("so_trang"),
                                        rs.getDate("ngay_dang").toString(),rs.getString("img"));
                }
     			return sach.getID_Sach();
     		} catch (Exception e) {
     			System.out.println(e);
     			return 0;
     		}
     	}
         public static void main(String[] args) {
                SachDao s=new SachDao();
                List<Sach> ls=new ArrayList<>();
                ls=s.getAllSach();
                for(Sach i:ls)
                		System.out.println(i);
        	
    }
	
}
