/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Test.LoginPage;
import View.View_QLHangHoaAdmin;

public class Controller_DangXuatAdmin implements ActionListener {
	View_QLHangHoaAdmin view;
	
	public Controller_DangXuatAdmin(View_QLHangHoaAdmin view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Dang Xuat")) {
			int out = JOptionPane.showConfirmDialog(null, "Ban co chac la muon dang xuat khong?", "Xac nhan dang xuat", JOptionPane.YES_NO_OPTION);
            if (out == JOptionPane.YES_OPTION) {
            	this.view.dispose();
            	LoginPage loginPage = new LoginPage();
            } 
		}
	}
	
}
