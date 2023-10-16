package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.HangHoaModelUser;
import View.ViewSuaThongTinUser;
import View.View_User;

public class ControlUser implements ActionListener, MouseListener {

	private View_User view;
	
	private int row;
	private ArrayList<HangHoaModelUser> hh = new ArrayList<>();
	private ViewSuaThongTinUser cs;
	
	
	
	public ControlUser(View_User view) {
		super();
		this.view = view;
for(int i=0; i<view.list.size();i++) {
	
	this.hh.add(view.list.get(i));
	
}





		
	}
	




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.row=view.getBang().getSelectedRow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Sua")) {
			
			cs = new ViewSuaThongTinUser(this.view.list, row, this.view);
			this.cs.setControl(this.view.getControlEdit());
			this.view.getControlEdit().setChinhSua(cs);
			
			} if(e.getActionCommand().equals("Them")) {
			if(view.getTextField().getText().equals("") || view.getTextField_1().getText().equals("")||view.getTextField_2().getText().equals("")|| view.getTextField_3().getText().equals("")||view.getTextField_4().getText().equals("") ||view.getTextField_5().getText().equals("")) {
				JOptionPane.showMessageDialog(this.view, "Bạn đang để trống thông tin. Vui lòng nhập lại");
				
			} else {
				String id = view.getTextField().getText();
				String ten = view.getTextField_1().getText();
				String gia = view.getTextField_2().getText();
				String soLuong = view.getTextField_3().getText();
				String daNhap = view.getTextField_4().getText();
				String ngayNhap = view.getTextField_5().getText();
				HangHoaModelUser clone = new HangHoaModelUser(id, ten, gia, soLuong, daNhap, ngayNhap);
				
				view.list.add(clone);
				view.model.addRow(new Object[] {clone.getId(),clone.getTen(),clone.getGia(),
						clone.getSoLuong(),clone.getDaNhap(),clone.getNgayNhap()
						
				});
				view.getControlEdit().setBang(view.model);
				view.getControlEdit().setDanhSach(view.list);
				view.xuatDuLieuVaoTxt("danhSachNhapKho.txt", view.list,view.chuoiNgayXuatVaDaXuat);
				
				 view.getTextField().setText("");
			     view.getTextField_1().setText("");
				 view.getTextField_2().setText("");
				 view.getTextField_3().setText("");
				 view.getTextField_4().setText("");
				 view.getTextField_5().setText("");
				
				JOptionPane.showMessageDialog(this.view, "Them hang hoa thanh cong!");
			}
			
			
			
		} if(e.getActionCommand().equals("Xoa")) {
			if(view.list.size() ==0) {
				JOptionPane.showMessageDialog(this.view, "Danh sách đang trống. Vui lòng nhập thêm dữ liệu");
			}
			view.list.remove(row);
			view.model.removeRow(row);
			   for (int i = row; i < view.list.size(); i++) {
				   view.list.get(i).setId(String.valueOf(i + 1));
				   view.model.setValueAt(view.list.get(i).getId(), i, 0);
				   view.model.setValueAt(view.list.get(i).getTen(), i, 1);
				   view.model.setValueAt(view.list.get(i).getGia(), i, 2);
				   view.model.setValueAt(view.list.get(i).getSoLuong(), i, 3);
				   view.model.setValueAt(view.list.get(i).getDaNhap(), i, 4);
				   view.model.setValueAt(view.list.get(i).getNgayNhap(), i, 5);
			      
			    }
			   view.getControlEdit().setBang(view.model);
				view.getControlEdit().setDanhSach(view.list);
				view.xuatDuLieuVaoTxt("danhSachNhapKho.txt", view.list,view.chuoiNgayXuatVaDaXuat);
				
				JOptionPane.showMessageDialog(this.view, "Xoa hang hoa thanh cong!");
		}
		
	}
public ViewSuaThongTinUser getCs() {
	return cs;
}
}
