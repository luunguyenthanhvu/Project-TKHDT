package Model;

public class HangHoaModelUser {
private String id;
private String ten;
private String gia;
private String soLuong;
private String daNhap;
private String ngayNhap;
public HangHoaModelUser(String id, String ten, String gia, String soLuong, String daNhap, String ngayNhap) {
	super();
	this.id = id;
	this.ten = ten;
	this.gia = gia;
	this.soLuong = soLuong;
	this.daNhap = daNhap;
	this.ngayNhap = ngayNhap;
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
public String getGia() {
	return gia;
}
public void setGia(String gia) {
	this.gia = gia;
}
public String getSoLuong() {
	return soLuong;
}
public void setSoLuong(String soLuong) {
	this.soLuong = soLuong;
}
public String getDaNhap() {
	return daNhap;
}
public void setDaNhap(String daNhap) {
	this.daNhap = daNhap;
}
public String getNgayNhap() {
	return ngayNhap;
}
public void setNgayNhap(String ngayNhap) {
	this.ngayNhap = ngayNhap;
}
@Override
public String toString() {
	return "HangHoa [id=" + id + ", ten=" + ten + ", gia=" + gia + ", soLuong=" + soLuong + ", daNhap=" + daNhap
			+ ", ngayNhap=" + ngayNhap + "]";
}


}
