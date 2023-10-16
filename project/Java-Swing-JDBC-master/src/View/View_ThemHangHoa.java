/*
* @author PC
*
*/
package View;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller_ThemHangHoa;

public class View_ThemHangHoa extends JFrame{
	public JPanel p1,p2;
	public JLabel l1,l2,l3,l4,l5;
	public JTextField t1,t2,t3,t4;
	public JComboBox t5;
	public JDateChooser ng;
	public JButton b1,b2;
	public DefaultTableModel dataModel;
	public Controller_ThemHangHoa themHH;
	public View_ThemHangHoa(String s ,DefaultTableModel model) {
		super(s);
		dataModel=model;
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5,2));
		l1 = new JLabel("ID");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		t1 = new JTextField();
		t1.setText(String.valueOf(View_QLHangHoaAdmin.getList().size()+1));
		t1.setEnabled(false);
		p1.add(l1);
		p1.add(t1);
		l2 = new JLabel("Ten");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		t2 = new JTextField();
		p1.add(l2);
		p1.add(t2);		
		l3 = new JLabel("Gia");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		t3 = new JTextField();
		p1.add(l3);
		p1.add(t3);		
		l4 = new JLabel("SoLuong");
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		t4 = new JTextField();
		p1.add(l4);
		p1.add(t4);	
		l5 = new JLabel("Ngay Nhap");
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		ng = new JDateChooser();
		ng.setDateFormatString("dd-MM-yyyy");
		
		
		p1.add(l5);
		p1.add(ng);
		this.add(p1,"North");
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		b1 = new JButton("OK");
		ActionListener ac = new Controller_ThemHangHoa(this);
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
	public void thongBao() {
		JOptionPane.showMessageDialog(rootPane, "Them hang hoa thanh cong!");
	}
}
