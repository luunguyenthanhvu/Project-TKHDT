/*
* @author PC
*
*/
package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller_XuatKho;

public class View_XuatKho extends JFrame{
	public JPanel p1,p2;
	public JLabel l1,l2,l3;
	public JTextField t1,t2,t3;
	public JButton b1,b2;
	public DefaultTableModel dataModel;
	public View_QLHangHoaAdmin viewAdmin;
	
	public JDateChooser ng;
	public View_XuatKho(String s,  DefaultTableModel model,View_QLHangHoaAdmin viewAdmin) {
		super(s);
		dataModel = model;
		this.viewAdmin=viewAdmin;
		p1 = new JPanel();
		p2 = new JPanel();
		l1 = new JLabel("ID");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2 = new JLabel("SoLuong");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		t1 = new JTextField();
		t2 = new JTextField();
		l3 = new JLabel("NgayXuat");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		t3 = new JTextField("00-00-0000");
		p1.setLayout(new GridLayout(3,2));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		ng = new JDateChooser();
		ng.setDateFormatString("dd-MM-yyyy");
		p1.add(ng);
		this.add(p1,"North");
		
		p2.setLayout(new FlowLayout());
		b1 = new JButton("OK");
		ActionListener ac = new Controller_XuatKho(this,this.viewAdmin);
		b1.addActionListener(ac);
		b2 = new JButton("Cancel");
		b2.addActionListener(ac);
		p2.add(b1);
		p2.add(b2);
		this.add(p2,"South");
		setSize(350,250);
		setLocation(525,350);
		setVisible(true);
	}
	public void thongBaoOK() {
		JOptionPane.showMessageDialog(rootPane, "Xuat hang hoa thanh cong!");
	}
	public void thongBaoKhongOK() {
		JOptionPane.showMessageDialog(rootPane, "Khong co hang hoa trong kho!");
	}
}
