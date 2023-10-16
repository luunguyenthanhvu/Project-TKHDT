package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.HangHoaModelUser;
import View.ViewSuaThongTinUser;
import View.View_User;

public class ControlForEditUser implements ActionListener{

	private ViewSuaThongTinUser chinhSua;
	
	private View_User view;
	private ArrayList<HangHoaModelUser> danhSach;
	private DefaultTableModel bang;

		
	public ControlForEditUser(View_User view) {
		this.view = view;
		this.chinhSua=this.view.getControl().getCs();
	    this.danhSach = view.list;
	   
	    this.bang=view.model;
	



	}
	

	
	public void setChinhSua(ViewSuaThongTinUser cs) {
		this.chinhSua=cs;
	}
	public void setDanhSach(ArrayList<HangHoaModelUser> danhSach) {
		this.danhSach = danhSach;
	}

	public void setBang(DefaultTableModel bang) {
		this.bang = bang;
	}
	public ArrayList<HangHoaModelUser> getDanhSachBenControlEdit() {
		return this.danhSach;
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("OK")) {
		
		
			String id = chinhSua.getTextField();
			
			String ten = chinhSua.getTextField_1();
			String gia = chinhSua.getTextField_2();
			String soLuong = chinhSua.getTextField_3();
			String daNhap = chinhSua.getTextField_4();
			String ngayNhap = chinhSua.getTextField_5();
			
			HangHoaModelUser clone = new HangHoaModelUser(id, ten, gia, soLuong, daNhap, ngayNhap);
			
			this.danhSach.set(chinhSua.getRow(), clone);
			this.bang.insertRow(chinhSua.getRow(), new Object[] {
					clone.getId(),clone.getTen(),clone.getGia(),clone.getSoLuong(),
					clone.getDaNhap(),clone.getNgayNhap()
			});
			this.bang.removeRow(chinhSua.getRow()+1);
			this.bang.fireTableDataChanged();
			view.xuatDuLieuVaoTxt("danhSachNhapKho.txt", view.list,view.chuoiNgayXuatVaDaXuat);
			JOptionPane.showMessageDialog(this.chinhSua, "Chinh sua hang hoa thanh cong!");
			this.chinhSua.dispose();
			
			
		} if(e.getActionCommand().equals("Cancel")) {
			this.chinhSua.dispose();
		}
		
	}


	

}
