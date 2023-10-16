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
import View.View_ThemHangHoa;

public class Controller_ThemHangHoa implements ActionListener{
	private View_ThemHangHoa view;
	private View_QLHangHoaAdmin result;
	
	public Controller_ThemHangHoa(View_ThemHangHoa view) {
		super();
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			String id=view.t1.getText();
			String ten=view.t2.getText();
			float gia=Float.valueOf(view.t3.getText());
			int soLuong=Integer.valueOf(view.t4.getText());
			//String ngayNhap = t5.getSelectedItem().toString();
			DateFormat gg = new SimpleDateFormat("dd-MM-yyyy");
			
			String ngayNhap = gg.format(view.ng.getDate());
			
			QLHHModel hanghoa = new QLHHModel(id, ten, gia, soLuong, soLuong, ngayNhap, 0, "00-00-0000");
			View_QLHangHoaAdmin.getList().add(hanghoa);
			view.dataModel.addRow(new Object[] {hanghoa.getId(),hanghoa.getTen(),hanghoa.getGia(),
					hanghoa.getSoLuong(),hanghoa.getDaNhap(),hanghoa.getNgayNhap()
					,hanghoa.getDaXuat(),hanghoa.getNgayXuat()
			});
			view.dispose();
			view.thongBao();
				
		}
		else if(e.getActionCommand().equals("Cancel")) {
			view.dispose();
		}
	}

}
