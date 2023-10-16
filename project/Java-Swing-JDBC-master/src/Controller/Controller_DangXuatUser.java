/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Test.LoginPage;
import View.View_User;

public class Controller_DangXuatUser implements ActionListener{
	View_User view;

	public Controller_DangXuatUser(View_User view) {
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
