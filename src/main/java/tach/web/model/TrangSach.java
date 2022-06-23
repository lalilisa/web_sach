package tach.web.model;

public class TrangSach {
	private String tenSachKhongDau;
	private int ID_Trang;
	private String noiDung;
	public TrangSach() {
		// TODO Auto-generated constructor stub
	}
	public TrangSach(String tenSachKhongDau, int iD_Trang, String noiDung) {
	
		this.tenSachKhongDau = tenSachKhongDau;
		ID_Trang = iD_Trang;
		this.noiDung = noiDung;
	}
	public String getTenSachKhongDau() {
		return tenSachKhongDau;
	}
	public void setTenSachKhongDau(String tenSachKhongDau) {
		this.tenSachKhongDau = tenSachKhongDau;
	}
	public int getID_Trang() {
		return ID_Trang;
	}
	public void setID_Trang(int iD_Trang) {
		ID_Trang = iD_Trang;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	@Override
	public String toString() {
		return "TrangSach [tenSachKhongDau=" + tenSachKhongDau + ", ID_Trang=" + ID_Trang + ", noiDung="
				+ noiDung + "]";
	}
	
	
}
