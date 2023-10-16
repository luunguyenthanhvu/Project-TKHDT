import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

public class QLHangHoa extends JFrame implements ActionListener,MouseListener{
	
	 
	private static QLHangHoa instance = null;
	JScrollPane sp;
	JPanel p,pKiet;
	JTable tb;
	DefaultTableModel model;
	 static  ArrayList<HangHoa> list = new ArrayList<>();
	JButton bNew,bEdit,bDelete,bThongKe,bThongKeTime,bTimKiem,bSapXep,bLamMoi;
	JLabel lableTK,lableSX,lableTimKiem,lableSapXep,tenSV;
	JComboBox comSX;
	
	JTextField tfTK,tfSX;
	static int getRow;
	
	public static ArrayList<HangHoa> getList() {
		return list;
	}
	
	public static QLHangHoa getInstance() {
	    if (instance == null) {
	        instance = new QLHangHoa("Quan Ly Hang Hoa Xuat Nhap Kho");
	    }
	    return instance;
	}

	
	private  QLHangHoa(String s) {

		super(s);
		setLayout(new BorderLayout());
		
		pKiet = new JPanel();
		pKiet.setLayout(new FlowLayout());
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Desktop\\vkuu.PNG"));
		//JLabel tenSV = new JLabel("Hoang Le Tuan Kiet : 20it009");
		tenSV = new JLabel("Quan ly hang hoa Xuat Nhap kho");
		tenSV.setForeground(new Color(255, 0, 0));
		tenSV.setFont(new Font("Sitka Text", Font.BOLD, 24));
        
		pKiet.add(img,BorderLayout.WEST);
		pKiet.add(tenSV,BorderLayout.CENTER);
		pKiet.setBackground(new Color(224, 255, 255));
		
		this.add(pKiet,BorderLayout.NORTH);
		
		tb = new JTable();
		tb.addMouseListener(this);
	
		model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Ten");
		model.addColumn("Gia");
		model.addColumn("So Luong");
		model.addColumn("Da Nhap");
		model.addColumn("Ngay Nhap");
		model.addColumn("Da Xuat");
		model.addColumn("Ngay Xuat");
		
		tb.setModel(model);
		sp = new JScrollPane(tb);
		sp.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "DANH SACH HANG HOA   ", TitledBorder.CENTER, 
				TitledBorder.TOP, null, Color.MAGENTA));
		this.add(sp,BorderLayout.CENTER);
		sp.setBackground(new Color(204, 255, 204));
		
		p = new JPanel();
		bNew = new JButton("Nhap Hang Hoa Moi");
		bNew.addActionListener(this);
		
		bEdit = new JButton("Chinh Sua Thong Tin");
		bEdit.addActionListener(this);
		
		bDelete = new JButton("Xuat Hang Hoa");
		bDelete.addActionListener(this);
		
		bThongKe = new JButton("Thong Ke Hang Hoa");
		bThongKe.addActionListener(this);
		bThongKeTime = new JButton("Thong Ke Theo Thoi Gian");
		bThongKeTime.addActionListener(this);
		
		lableTK = new JLabel("Tim Kiem");
		lableTK.setHorizontalAlignment(SwingConstants.CENTER);
		lableTimKiem = new JLabel("Nhap Id hoac Ten");
		lableTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		tfTK = new JTextField("");
		bTimKiem = new JButton("Tim Kiem");
		bTimKiem.addActionListener(this);
		
		lableSX = new JLabel("Sap Xep");
		lableSX.setHorizontalAlignment(SwingConstants.CENTER);
		
		lableSapXep = new JLabel("Chon Thong Tin Muon Sap Xep");
		lableSapXep.setHorizontalAlignment(SwingConstants.CENTER);
		comSX = new JComboBox();
		comSX.addItem("Ten");
		comSX.addItem("Gia");
		comSX.addItem("So Luong");
		comSX.addItem("Ngay Nhap Kho");
		comSX.addItem("Ngay Xuat Kho");
		bSapXep = new JButton("Sap Xep");
		bSapXep.addActionListener(this);
		bLamMoi = new JButton("Xoa Hang Hoa");
		bLamMoi.addActionListener(this);
		//Lam mau
		bNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		bNew.setBackground(new Color(153, 255, 102));
		bNew.setForeground(Color.BLACK);
		
		bDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		bDelete.setBackground(new Color(153, 255, 102));
		bDelete.setForeground(Color.BLACK);
		
		bEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		bEdit.setBackground(new Color(153, 255, 102));
		bEdit.setForeground(Color.BLACK);
		
		bLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		bLamMoi.setBackground(new Color(153, 255, 102));
		bLamMoi.setForeground(Color.BLACK);
		
		bThongKe.setFont(new Font("Tahoma", Font.BOLD, 12));
		bThongKe.setBackground(new Color(51, 255, 255));
		bThongKe.setForeground(Color.BLACK);
		
		bThongKeTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		bThongKeTime.setBackground(new Color(51, 255, 255));
		bThongKeTime.setForeground(Color.BLACK);
		
		bTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		bTimKiem.setBackground(new Color(51, 255, 255));
		bTimKiem.setForeground(Color.BLACK);
		
		bSapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		bSapXep.setBackground(new Color(51, 255, 255));
		bSapXep.setForeground(Color.BLACK);
		
		lableTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableTK.setForeground(Color.BLACK);
		lableSX.setFont(new Font("Tahoma", Font.BOLD, 14));
		lableSX.setForeground(Color.BLACK);
		
		lableTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lableTimKiem.setForeground(Color.BLACK);
		lableSapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lableSapXep.setForeground(Color.BLACK);
		
		//Add
		p.setLayout(new GridLayout(6,3));
		p.setBackground(new Color(204, 255, 204));
		p.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "CAC CHUC NANG  ", 
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.MAGENTA));
		p.add(bNew);
		p.add(lableTK);
		p.add(lableSX);
		
		p.add(bDelete);
		p.add(lableTimKiem);
		p.add(lableSapXep);
		
		p.add(bEdit);
		p.add(tfTK);
		p.add(comSX);
		
		p.add(bLamMoi);
		p.add(bTimKiem);
		p.add(bSapXep);
		
		p.add(bThongKe);
		JLabel sv = new JLabel("Nhóm 14 : Thiết kế hướng đối tượng");
		sv.setFont(new Font("Tahoma", Font.BOLD, 13));
		sv.setBackground(new Color(51, 255, 255));
		sv.setForeground(new Color(255, 0, 0));
		sv.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(sv);
		
		JLabel svk = new JLabel("");
		svk.setFont(new Font("Tahoma", Font.BOLD, 13));
		svk.setBackground(new Color(51, 255, 255));
		svk.setForeground(new Color(255, 0, 0));
		svk.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(svk);
		
		p.add(bThongKeTime);
		
		JLabel svid = new JLabel("Lớp : ");
		svid.setFont(new Font("Tahoma", Font.BOLD, 13));
		svid.setBackground(new Color(51, 255, 255));
		svid.setForeground(new Color(255, 0, 0));
		svid.setHorizontalAlignment(SwingConstants.RIGHT);
		p.add(svid);
		
		JLabel svl = new JLabel("DH21DTD");
		svl.setFont(new Font("Tahoma", Font.BOLD, 13));
		svl.setBackground(new Color(51, 255, 255));
		svl.setForeground(new Color(255, 0, 0));
		svl.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(svl);
		
		this.add(p,BorderLayout.SOUTH);
		setLocation(300,100);
		setSize(800,500);
		setVisible(true);
		
//		Nhập sẵn dữ liệu
		list.add(new HangHoa("1","But",5000,50,50,"16-03-2023",20,"17-03-2023"));
		list.add(new HangHoa("2","Nuoc",10000,150,150,"20-03-2023",100,"31-04-2023"));
		list.add(new HangHoa("3","Xe",50000000,5000,50000,"15-03-2023",3200,"12-04-2023"));
		list.add(new HangHoa("4","Quat",300000,100,100,"16-03-2023",50,"20-03-2023"));
		list.add(new HangHoa("5","Ban",200000,1000,1000,"05-03-2023",300,"19-03-2023"));
		list.add(new HangHoa("6","O to",1200000000,50,50,"16-03-2023",25,"01-04-2023"));
		
		for(HangHoa hh: list) {
			model.addRow(new Object[] {hh.getId(),hh.getTen(),hh.getGia(),
					hh.getSoLuong(),hh.getDaNhap(),hh.getNgayNhap()
					,hh.getDaXuat(),hh.getNgayXuat()});
		}
		

		
		
	}
	
		

	public void mouseClicked(MouseEvent e) {
		getRow = Integer.valueOf(tb.getSelectedRow());
		System.out.println(getRow);
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Nhap Hang Hoa Moi")) {
			new NhapKho("Nhap Hang Hoa Moi", model);
		}
		else if(e.getActionCommand().equals("Xuat Hang Hoa")) {
			new XuatKho("Xuat Hang Hoa",  model);
		}
		else if(e.getActionCommand().equals("Chinh Sua Thong Tin")) {
			new ChinhSua("Chinh Sua Thong Tin",list,model,getRow);
		}
		else if(e.getActionCommand().equals("Thong Ke Hang Hoa")) {
			FactoryThongKe.getThongKe(e.getActionCommand());
		}
		else if(e.getActionCommand().equals("Thong Ke Theo Thoi Gian")) {
			FactoryThongKe.getThongKe(e.getActionCommand());
		}
		else if(e.getActionCommand().equals("Tim Kiem")) {
			boolean b=false;
			for (HangHoa o : list) {
				if((o.getId().equals(tfTK.getText()))||(o.getTen().equals(tfTK.getText()))){
					b=true;
				}
			}
			if(tfTK.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Khong co du lieu");
			else if(b) new TimKiem("Tim Kiem", list, tfTK.getText());
			else JOptionPane.showMessageDialog(rootPane, "Khong co trong kho");
		}
		else if(e.getActionCommand().equals("Sap Xep")) {
			String clone = comSX.getSelectedItem().toString();
			new SapXep("Sap Xep", list, clone);

		}
		else if(e.getActionCommand().equals("Xoa Hang Hoa")) {
			new XoaHangHoa(list, model, getRow);		
		}
		 
	}
	
	public static void main(String[] args) {
		QLHangHoa singletonInstance = QLHangHoa.getInstance();
	}
}