import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SapXep extends JFrame implements ActionListener{
	
	JScrollPane sp;
	JPanel p,TieuDe;
	JTable tb;
	DefaultTableModel model;
	ArrayList<HangHoa> hh = new ArrayList<>();
	JButton ok;
	SXStrategy sxStrategy;
	
	public void setSapXepStraregy(SXStrategy sxStrategy) {
		this.sxStrategy = sxStrategy;
	}
	public void sort() {
		sxStrategy.sort(hh);
	}
	public SapXep(String s, ArrayList<HangHoa> h, String name) {
		super(s);
		for(HangHoa h1: h) {
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
		
		for (HangHoa e : hh) {
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
		ok.addActionListener(this);
		p = new JPanel();
		p.add(ok);
		p.setLayout(new FlowLayout());
		this.add(p,BorderLayout.SOUTH);
		setLocation(400,200);
		setSize(600,300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}
	}
}
