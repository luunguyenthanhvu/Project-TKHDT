/*
* @author PC
*
*/
package Model;

public class QLHHModel {
	public String id;
	public String ten;
	public double gia;
	public int soLuong;
	public int daNhap;
	public String ngayNhap;
	public int daXuat;
	public String ngayXuat;
	public QLHHModel() {
		
	}
	
	public QLHHModel(String id, String ten, double gia, int soLuong) {
		super();
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.soLuong = soLuong;
	}

	public QLHHModel(String id, String ten, double gia, int soLuong, int daNhap, int daXuat) {
		super();
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.soLuong = soLuong;
		this.daNhap = daNhap;
		this.daXuat = daXuat;
	}
	
	public QLHHModel(String id, String ten, double gia, int soLuong, int daNhap, String ngayNhap, int daXuat,
			String ngayXuat) {
		super();
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.soLuong = soLuong;
		this.daNhap = daNhap;
		this.ngayNhap = ngayNhap;
		this.daXuat = daXuat;
		this.ngayXuat = ngayXuat;
	}
	
	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDaNhap() {
		return daNhap;
	}
	public void setDaNhap(int daNhap) {
		this.daNhap = daNhap;
	}
	public int getDaXuat() {
		return daXuat;
	}
	public void setDaXuat(int daXuat) {
		this.daXuat = daXuat;
	}
}
