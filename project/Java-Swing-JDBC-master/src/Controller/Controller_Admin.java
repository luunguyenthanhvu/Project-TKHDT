/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import View.View_ChinhSuaHangHoa;
import View.View_QLHangHoaAdmin;
import View.View_SapXepHangHoa;
import View.View_ThemHangHoa;
import View.View_ThongKeHangHoa;
import View.View_ThongKeHangHoaTime;
import View.View_TimKiemHangHoa;
import View.View_XuatKho;

public class Controller_Admin implements ActionListener, MouseListener {
	View_QLHangHoaAdmin view;
    int getRow=0;
    String s = "Quan ly hang hoa";
	public Controller_Admin(View_QLHangHoaAdmin view) {
		super();
		this.view = view;
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		getRow = Integer.valueOf(view.tb.getSelectedRow());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Xuat Hang Hoa")) {
			View_XuatKho view2 = new View_XuatKho(s, view.model,view);
		} else if (e.getActionCommand().equals("Chinh Sua Thong Tin")) {
			View_ChinhSuaHangHoa view3 = new View_ChinhSuaHangHoa(s, view.list, view.model, getRow,view);
		} else if (e.getActionCommand().equals("Thong Ke Hang Hoa")) {
			View_ThongKeHangHoa view4 = new View_ThongKeHangHoa(s, view.list);
		} else if (e.getActionCommand().equals("Thong Ke Theo Thoi Gian")) {
			View_ThongKeHangHoaTime view5 = new View_ThongKeHangHoaTime(s, view.list);
		} else if (e.getActionCommand().equals("Tim Kiem")) {
			String products = view.tfTK.getText();
			if(products.equals("")) {
				View_TimKiemHangHoa view61 = new View_TimKiemHangHoa();
				view61.thongChuaNhap();
			} else {
			View_TimKiemHangHoa view62 = new View_TimKiemHangHoa(s, view.list, products);

		}
		} else if (e.getActionCommand().equals("Sap Xep")) {
			String name = view.comSX.getSelectedItem().toString();
			View_SapXepHangHoa view7 = new View_SapXepHangHoa(s, view.list, name);
		} 
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
	
}
