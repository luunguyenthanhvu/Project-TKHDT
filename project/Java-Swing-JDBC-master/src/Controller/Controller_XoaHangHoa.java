/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.View_QLHangHoaAdmin;

public class Controller_XoaHangHoa implements ActionListener{
	View_QLHangHoaAdmin view;
	
	public Controller_XoaHangHoa(View_QLHangHoaAdmin view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = view.tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng hóa để xóa!");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hàng hóa này không?", "Xác nhận xóa hàng hóa", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
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
                    view.model.setValueAt(view.list.get(i).getDaXuat(), i, 6);
                    view.model.setValueAt(view.list.get(i).getNgayXuat(), i, 7);
                }
                this.view.xuatDuLieuVaoTxt("danh sach cua admin.txt", this.view.list);
                this.view.xuatDuLieuVaoTxtNhanVien("danh sach cua admin.txt", "danhSachNhapKho.txt");
            }
            
            
	}
        
	}
}


