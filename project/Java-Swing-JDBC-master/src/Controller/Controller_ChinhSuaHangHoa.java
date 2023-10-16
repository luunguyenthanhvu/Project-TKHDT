/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import Model.QLHHModel;
import View.View_ChinhSuaHangHoa;
import View.View_QLHangHoaAdmin;

public class Controller_ChinhSuaHangHoa implements ActionListener{
	private View_ChinhSuaHangHoa view;
	private View_QLHangHoaAdmin admin;
	public Controller_ChinhSuaHangHoa(View_ChinhSuaHangHoa view,View_QLHangHoaAdmin admin) {
		super();
		this.view = view;
		this.admin=admin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			String id = view.t1.getText();
			int row = Integer.valueOf(id);
			String ten = view.t2.getText();
			double gia = Double.valueOf(view.t3.getText());
			int soLuong = Integer.valueOf(view.t4.getText());
			int daNhap = Integer.valueOf(view.t5.getText());
			
			//String ngayNhap = t55.getText();
			DateFormat gg = new SimpleDateFormat("dd-MM-yyyy");			
			String ngayNhap = gg.format(view.ng.getDate());
			
			int daXuat = Integer.valueOf(view.t6.getText());
			
			//String ngayXuat = t66.getText();
			DateFormat gg1 = new SimpleDateFormat("dd-MM-yyyy");
			String ngayXuat = gg1.format(view.ng1.getDate());
			
			QLHHModel clone = new QLHHModel(id, ten, gia, soLuong, daNhap, ngayNhap, daXuat, ngayXuat);
			
			view.hh.set(row-1, clone);
				this.view.dataModel.insertRow(row-1, new Object[] {
						clone.getId(),clone.getTen(),clone.getGia(),clone.getSoLuong(),
						clone.getDaNhap(),clone.getNgayNhap(),clone.getDaXuat(),clone.getNgayXuat()
				});
				this.view.dataModel.removeRow(row);
				this.view.dataModel.fireTableDataChanged();
				this.admin.xuatDuLieuVaoTxt("danh sach cua admin.txt",this.view.hh );
				this.admin.xuatDuLieuVaoTxtNhanVien("danh sach cua admin.txt", "danhSachNhapKho.txt");
				this.view.thongBao();
				this.view.dispose();
			
		}
		else 
			if(e.getActionCommand().equals("Cancel")) {
				this.view.dispose();
			}
	}

}
