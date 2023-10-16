/*
* @author PC
*
*/
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_ThongKeTime;
import Model.AThongKe;
import Model.QLHHModel;

public class View_ThongKeHangHoaTime extends AThongKe{
	public JPanel p,p1,p2;
	public JScrollPane spN,spX;
	public JTable tbNhap,tbXuat;
	public DefaultTableModel dataNhap,dataXuat;
	public JTextField time1,time2;
	public JButton ok,x,rf;
	public JRootPane rootPane;
	
	public View_ThongKeHangHoaTime(String s, ArrayList<QLHHModel> h) {
		super(s, h);
		dataNhap = new DefaultTableModel();
		dataNhap.addColumn("Da Nhap");
		dataNhap.addColumn("So Luong Nhap");
		dataNhap.addColumn("Thoi Gian Nhap");
		tbNhap = new JTable();
		tbNhap.setModel(dataNhap);
		
		dataXuat = new DefaultTableModel();
		dataXuat.addColumn("Da Xuat");
		dataXuat.addColumn("So Luong Xuat");
		dataXuat.addColumn("Thoi Gian Xuat");
		tbXuat = new JTable();
		tbXuat.setModel(dataXuat);
		
		spN = new JScrollPane(tbNhap);
		spX = new JScrollPane(tbXuat);
		
		p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		p.add(spN);
		p.add(spX);
		
		p1 = new JPanel();
		JLabel ltitle = new JLabel("Thong Ke Trong Khoang Thoi Gian");
		p1.add(ltitle);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,4));
		JLabel l1 = new JLabel("Thoi gian tu : ");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l2 = new JLabel("Cho den : ");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		time1 = new JTextField();
		time2 = new JTextField();
		ok = new JButton("OK");
		ActionListener ac = new Controller_ThongKeTime(this);
		ok.addActionListener(ac);
		x = new JButton("Cancel");
		x.setForeground(new Color(255, 0, 0));
		x.addActionListener(ac);
		rf = new JButton("Refresh");
		rf.addActionListener(ac);
		p2.add(l1);
		p2.add(time1);
		p2.add(l2);
		p2.add(time2);
		p2.add(new JLabel());
		p2.add(ok);
		p2.add(rf);
		p2.add(x);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		setLocation(400,200);
		setSize(600, 300);
		setVisible(true);
	}
}
