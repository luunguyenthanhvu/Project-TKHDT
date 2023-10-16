/*
* @author PC
*
*/
package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_SapXepHangHoa;
import Model.QLHHModel;
import Model.SXStrategy;
import Model.SXTheoGia;
import Model.SXTheoNNK;
import Model.SXTheoNXK;
import Model.SXTheoSoLuong;
import Model.SXTheoTen;


public class View_SapXepHangHoa extends JFrame{
	JScrollPane sp;
	JPanel p,TieuDe;
	JTable tb;
	DefaultTableModel model;
	ArrayList<QLHHModel> hh = new ArrayList<>();
	JButton ok;
	SXStrategy sxStrategy;
	
	public void setSapXepStraregy(SXStrategy sxStrategy) {
		this.sxStrategy = sxStrategy;
	}
	public void sort() {
		sxStrategy.sort(hh);
	}
	public View_SapXepHangHoa(String s, ArrayList<QLHHModel> h, String name) {
		super(s);
		for(QLHHModel h1: h) {
			hh.add(h1);
		}
		setLayout(new BorderLayout());
		tb = new JTable();
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Ten");
		model.addColumn("Gia");
		model.addColumn("So Luong");
		model.addColumn("Da Nhap");
		model.addColumn("Ngay Nhap");
		model.addColumn("Da Xuat");
		model.addColumn("Ngay Xuat");
		if(name=="Ten") {
			setSapXepStraregy(new SXTheoTen());
			sort();
			
		} else if (name=="Gia"){
			setSapXepStraregy(new SXTheoGia());
			sort();
			
		} else if(name=="So Luong") {
			setSapXepStraregy(new SXTheoSoLuong());
			sort();
			
		} else if(name=="Ngay Nhap Kho") {
			setSapXepStraregy(new SXTheoNNK());
			sort();
			
		} else if(name=="Ngay Xuat Kho") {
			setSapXepStraregy(new SXTheoNXK());
			sort();
		}
		
		for (QLHHModel e : hh) {
			model.addRow(new Object[] {e.getId(),e.getTen(),e.getGia(),e.getSoLuong(),
					e.getDaNhap(),e.getNgayNhap(),e.getDaXuat(),e.getNgayXuat()});
		}
		tb.setModel(model);
		sp = new JScrollPane(tb);
		this.add(sp,BorderLayout.CENTER);
		
		TieuDe = new JPanel();
		TieuDe.setLayout(new FlowLayout());
		JLabel ten = new JLabel("Sap Xep Theo "+name);
		ten.setFont(new Font("Sitka Text", Font.BOLD, 20));
		TieuDe.add(ten,BorderLayout.CENTER);
		
		this.add(TieuDe,BorderLayout.NORTH);
		ok = new JButton("Cancel");
		ActionListener ac = new Controller_SapXepHangHoa(this);
		ok.addActionListener(ac);
		p = new JPanel();
		p.add(ok);
		p.setLayout(new FlowLayout());
		this.add(p,BorderLayout.SOUTH);
		setLocation(400,200);
		setSize(600,300);
		setVisible(true);
	}

}
