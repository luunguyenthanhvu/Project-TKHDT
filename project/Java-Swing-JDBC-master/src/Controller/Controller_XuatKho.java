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
import View.View_QLHangHoaAdmin;
import View.View_XuatKho;

public class Controller_XuatKho implements ActionListener{
	private View_XuatKho xuatKho;
	private View_QLHangHoaAdmin admin;
	
	public Controller_XuatKho(View_XuatKho xuatKho,View_QLHangHoaAdmin admin) {
		super();
		this.xuatKho = xuatKho;
		this.admin=admin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("OK")) {
			int id = Integer.valueOf(xuatKho.t1.getText());
			int soLuong = Integer.valueOf(xuatKho.t2.getText());
			//String ngayXuat = t3.getText();
			DateFormat gg = new SimpleDateFormat("dd-MM-yyyy");
			
			String ngayXuat = gg.format(xuatKho.ng.getDate());
			
			if(View_QLHangHoaAdmin.getList().get(id-1).getId().equals(String.valueOf(id)) 
						&& (View_QLHangHoaAdmin.getList().get(id-1).getSoLuong()>=soLuong)) {
				
				View_QLHangHoaAdmin.getList().set(id-1, new QLHHModel(View_QLHangHoaAdmin.getList().get(id-1).getId()
							, View_QLHangHoaAdmin.getList().get(id-1).getTen(), View_QLHangHoaAdmin.getList().get(id-1).getGia()
							, View_QLHangHoaAdmin.getList().get(id-1).getSoLuong()-soLuong
							, View_QLHangHoaAdmin.getList().get(id-1).getDaNhap(),View_QLHangHoaAdmin.getList().get(id-1).getNgayNhap()
							, View_QLHangHoaAdmin.getList().get(id-1).getDaXuat()+soLuong, ngayXuat));
					this.xuatKho.dataModel.insertRow(id-1, new Object[] {View_QLHangHoaAdmin.getList().get(id-1).getId(),View_QLHangHoaAdmin.getList().get(id-1).getTen()
							,View_QLHangHoaAdmin.getList().get(id-1).getGia(),View_QLHangHoaAdmin.getList().get(id-1).getSoLuong()
							,View_QLHangHoaAdmin.getList().get(id-1).getDaNhap(),View_QLHangHoaAdmin.getList().get(id-1).getNgayNhap()
							,View_QLHangHoaAdmin.getList().get(id-1).getDaXuat(),View_QLHangHoaAdmin.getList().get(id-1).getNgayXuat()
					});
					this.xuatKho.dataModel.removeRow(id);
					this.xuatKho.dataModel.fireTableDataChanged();
					this.admin.xuatDuLieuVaoTxt("danh sach cua admin.txt", this.admin.list);
					this.admin.xuatDuLieuVaoTxtNhanVien("danh sach cua admin.txt", "danhSachNhapKho.txt");
					this.xuatKho.thongBaoOK();
					this.xuatKho.dispose();
				
			}
			else this.xuatKho.thongBaoKhongOK();
		}
		else 
			if(e.getActionCommand().equals("Cancel")) {
				this.xuatKho.dispose();
			}
	}

}
