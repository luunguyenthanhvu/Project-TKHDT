/*
* @author PC
*
*/
package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller_ChinhSuaHangHoa;
import Model.QLHHModel;

public class View_ChinhSuaHangHoa extends JFrame{
	public JPanel p1,p2;
	public JLabel l1,l2,l3,l4,l5,l55,l6,l66;
	public JTextField t1,t2,t3,t4,t5,t55,t6,t66;
	public JButton b1,b2;
	public DefaultTableModel dataModel;
	public ArrayList<QLHHModel> hh = new ArrayList<QLHHModel>();
	public int Row;
	public JDateChooser ng,ng1;
	public View_QLHangHoaAdmin viewAdmin;

	public View_ChinhSuaHangHoa(String s, ArrayList<QLHHModel> h, DefaultTableModel model, int getRow,View_QLHangHoaAdmin viewAdmin) {
		super(s);
		Row = getRow;
		dataModel=model;
        this.viewAdmin = viewAdmin;
		for(int i =0; i<h.size();i++) {
			hh.add(h.get(i));
		}
	
		p1 = new JPanel();
		p1.setLayout(new GridLayout(8,2));
		l1 = new JLabel("ID");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		t1 = new JTextField(h.get(getRow).getId());
		t1.setEnabled(false);
		t1.setFont(new Font("Tahoma", Font.BOLD, 12));
		t1.setForeground(Color.RED);
		p1.add(l1);
		p1.add(t1);
		l2 = new JLabel("Ten");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		t2 = new JTextField(h.get(getRow).getTen());
		p1.add(l2);
		p1.add(t2);		
		l3 = new JLabel("Gia");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		t3 = new JTextField(String.valueOf(h.get(getRow).getGia()));
		p1.add(l3);
		p1.add(t3);		
		l4 = new JLabel("SoLuong");
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		t4 = new JTextField(String.valueOf(h.get(getRow).getSoLuong()));
		p1.add(l4);
		p1.add(t4);	
		l5 = new JLabel("DaNhap");
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		t5 = new JTextField(String.valueOf(h.get(getRow).getDaNhap()));
		
		p1.add(l5);
		p1.add(t5);
		l55 = new JLabel("NgayNhap");
		l55.setHorizontalAlignment(SwingConstants.CENTER);
		t55 = new JTextField(String.valueOf(h.get(getRow).getNgayNhap()));
		
		ng = new JDateChooser();
		ng.setDateFormatString("dd-MM-yyyy");
		
		String ngayNhapString = h.get(getRow).getNgayNhap();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date ngayNhapDate;
		try {
			ngayNhapDate = dateFormat.parse(ngayNhapString);
			ng.setDate(ngayNhapDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		p1.add(l55);
		p1.add(ng);
		l6 = new JLabel("DaXuat");
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		t6= new JTextField(String.valueOf(h.get(getRow).getDaXuat()));
		p1.add(l6);
		p1.add(t6);
		l66 = new JLabel("NgayXuat");
		l66.setHorizontalAlignment(SwingConstants.CENTER);
		t66 = new JTextField(String.valueOf(h.get(getRow).getNgayXuat()));
		ng1 = new JDateChooser();
		ng1.setDateFormatString("dd-MM-yyyy");
		p1.add(l66);
		p1.add(ng1);
		this.add(p1,"North");
		
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		b1 = new JButton("OK");
		ActionListener ac = new Controller_ChinhSuaHangHoa(this,viewAdmin);
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
		JOptionPane.showMessageDialog(rootPane, "Chinh sua hang hoa thanh cong!");
	}
}
