/*
* @author PC
*
*/
package View;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Admin;
import Controller.Controller_DangXuatAdmin;
import Controller.Controller_ThemHangHoa;
import Controller.Controller_XoaHangHoa;
import Model.HangHoaModelUser;
import Model.QLHHModel;
import Controller.Controller_ThemHangHoa;

public class View_QLHangHoaAdmin extends JFrame{
//	private static QLHHModel instance = null;
	public JScrollPane sp;
	public JPanel p,pKiet;
	public JTable tb;
	public static DefaultTableModel model;
	public static  ArrayList<QLHHModel> list = new ArrayList<>();
	public JButton bNew,bOut,bEdit,bDelete,bThongKe,bThongKeTime,bTimKiem,bSapXep,bLamMoi;
	public JLabel lableTK,lableSX,lableTimKiem,lableSapXep,tenSV;
	public JComboBox comSX;
	public JTextField tfTK,tfSX;
	public  int getRow;
	private Controller_Admin ac;
	private View_User user;
	
	public static ArrayList<QLHHModel> getList() {
		return list;
	}
	
//	public static View_QLHangHoaUser getInstance() {
//	    if (instance == null) {
//	        instance = new View_QLHangHoaUser("Quan Ly Hang Hoa Xuat Nhap Kho");
//	    }
//	    return instance;
//	}

	
	public  View_QLHangHoaAdmin(String s) {
        
		super(s);
		ac = new Controller_Admin(this);
		user = new View_User();
		MouseListener mc = new Controller_Admin(this);
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
		
		
		
	
		model = new DefaultTableModel();
		tb = new JTable(model) {
    	    @Override
    	    public boolean isCellEditable(int row, int column) {
    	        // Không cho phép chỉnh sửa
    	        return false;
    	    }
    	};
    	tb.addMouseListener(ac);
		model.addColumn("Id");
		model.addColumn("Ten");
		model.addColumn("Gia");
		model.addColumn("So Luong");
		model.addColumn("Da Nhap");
		model.addColumn("Ngay Nhap");
		model.addColumn("Da Xuat");
		model.addColumn("Ngay Xuat");
		
		
		
		sp = new JScrollPane(tb);
		sp.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "DANH SACH HANG HOA   ", TitledBorder.CENTER, 
				TitledBorder.TOP, null, Color.MAGENTA));
		this.add(sp,BorderLayout.CENTER);
		sp.setBackground(new Color(204, 255, 204));
		
		p = new JPanel();
		bOut = new JButton("Dang Xuat");
		
//		bNew.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				View_ThemHangHoa view = new View_ThemHangHoa(s, model);
//			}
//		});
		bOut.addActionListener(new Controller_DangXuatAdmin(this));
		
		bEdit = new JButton("Chinh Sua Thong Tin");
		bEdit.addActionListener(ac);
//		bEdit.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				View_ChinhSuaHangHoa view = new View_ChinhSuaHangHoa(s, list, model, getRow);
//			}
//		});
		
		bDelete = new JButton("Xuat Hang Hoa");
		bDelete.addActionListener(ac);
//		bDelete.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				View_XuatKho view = new View_XuatKho(s, model);
//			}
//		});
		bLamMoi = new JButton("Xóa hàng hóa");
		bLamMoi.addActionListener(new Controller_XoaHangHoa(this));
		bThongKe = new JButton("Thong Ke Hang Hoa");
		bThongKe.addActionListener(ac);
//		bThongKe.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				View_ThongKeHangHoa view = new View_ThongKeHangHoa(s, list);
//			}
//		});
		bThongKeTime = new JButton("Thong Ke Theo Thoi Gian");
		bThongKeTime.addActionListener(ac);
//		bThongKeTime.addActionListener( new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				View_ThongKeHangHoaTime view = new View_ThongKeHangHoaTime(s, list);
//			}
//		});
		lableTK = new JLabel("Tim Kiem");
		lableTK.setHorizontalAlignment(SwingConstants.CENTER);
		lableTimKiem = new JLabel("Nhap Id hoac Ten");
		lableTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		tfTK = new JTextField();
		bTimKiem = new JButton("Tim Kiem");
		bTimKiem.addActionListener(ac);
//		bTimKiem.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String products = tfTK.getText();
//				if(products.equals("")) {
//					JOptionPane.showMessageDialog(rootPane, "Vui long nhap ten hoac id hang hoa can tim!");
//				}
//				View_TimKiemHangHoa view = new View_TimKiemHangHoa(s, list, products);
////				View_TimKiemHangHoa view = new View_TimKiemHangHoa(s, list, products);
//			}
//		});
		
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
		bSapXep.addActionListener(ac);
//		bSapXep.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String name = comSX.getSelectedItem().toString();
//				View_SapXepHangHoa view = new View_SapXepHangHoa(s, list, name);
//			}
//		});
		//Lam mau
		bOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		bOut.setBackground(new Color(153, 255, 102));
		bOut.setForeground(Color.BLACK);
		
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
		p.add(bOut);
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
		JLabel sv = new JLabel("SINH VIEN : ");
		sv.setFont(new Font("Tahoma", Font.BOLD, 13));
		sv.setBackground(new Color(51, 255, 255));
		sv.setForeground(new Color(255, 0, 0));
		sv.setHorizontalAlignment(SwingConstants.RIGHT);
		p.add(sv);
		
		JLabel svk = new JLabel(" HOANG LE TUAN KIET");
		svk.setFont(new Font("Tahoma", Font.BOLD, 13));
		svk.setBackground(new Color(51, 255, 255));
		svk.setForeground(new Color(255, 0, 0));
		svk.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(svk);
		
		p.add(bThongKeTime);
		
		JLabel svid = new JLabel("MA SV : ");
		svid.setFont(new Font("Tahoma", Font.BOLD, 13));
		svid.setBackground(new Color(51, 255, 255));
		svid.setForeground(new Color(255, 0, 0));
		svid.setHorizontalAlignment(SwingConstants.RIGHT);
		p.add(svid);
		
		JLabel svl = new JLabel(" 20IT009");
		svl.setFont(new Font("Tahoma", Font.BOLD, 13));
		svl.setBackground(new Color(51, 255, 255));
		svl.setForeground(new Color(255, 0, 0));
		svl.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(svl);
		
		this.add(p,BorderLayout.SOUTH);
		setLocation(300,100);
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Nhập sẵn dữ liệu
		layDuLieuTuUserChoVaoTxt("danhSachNhapKho.txt","danh sach cua admin.txt");
		
          try {
			list= layDuLieuTuTxt("danh sach cua admin.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(QLHHModel hh: list) {
			model.addRow(new Object[] {hh.getId(),hh.getTen(),hh.getGia(),
					hh.getSoLuong(),hh.getDaNhap(),hh.getNgayNhap()
					,hh.getDaXuat(),hh.getNgayXuat() 	});
		}
		

		
		
	}
	
		

//	public void mouseClicked(MouseEvent e) {
//		getRow = Integer.valueOf(tb.getSelectedRow());
//	}
//	public void mousePressed(MouseEvent e) {}
//	public void mouseReleased(MouseEvent e) {}
//	public void mouseEntered(MouseEvent e) {}
//	public void mouseExited(MouseEvent e) {}

//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("Nhap Hang Hoa Moi")) {
//			new NhapKho("Nhap Hang Hoa Moi", model);
//		}
//		else if(e.getActionCommand().equals("Xuat Hang Hoa")) {
//			new XuatKho("Xuat Hang Hoa",  model);
//		}
//		else if(e.getActionCommand().equals("Chinh Sua Thong Tin")) {
//			new ChinhSua("Chinh Sua Thong Tin",list,model,getRow);
//		}
//		else if(e.getActionCommand().equals("Thong Ke Hang Hoa")) {
//			FactoryThongKe.getThongKe(e.getActionCommand());
//		}
//		else if(e.getActionCommand().equals("Thong Ke Theo Thoi Gian")) {
//			FactoryThongKe.getThongKe(e.getActionCommand());
//		}
//		else if(e.getActionCommand().equals("Tim Kiem")) {
//			boolean b=false;
//			for (HangHoa o : list) {
//				if((o.getId().equals(tfTK.getText()))||(o.getTen().equals(tfTK.getText()))){
//					b=true;
//				}
//			}
//			if(tfTK.getText().equals("")) JOptionPane.showMessageDialog(rootPane, "Khong co du lieu");
//			else if(b) new TimKiem("Tim Kiem", list, tfTK.getText());
//			else JOptionPane.showMessageDialog(rootPane, "Khong co trong kho");
//		}
//		else if(e.getActionCommand().equals("Sap Xep")) {
//			String clone = comSX.getSelectedItem().toString();
//			new SapXep("Sap Xep", list, clone);
//
//		}
//		 
//	}
//	
	public static void main(String[] args) {
//		View_QLHangHoaUser singletonInstance = View_QLHangHoaUser.getInstance();
		View_QLHangHoaAdmin view = new View_QLHangHoaAdmin("Quan Ly Hang Hoa");
	}
	public void layDuLieuTuUserChoVaoTxt(String url1, String url) {
		 try (BufferedReader reader = new BufferedReader(new FileReader(url1))) {
	            PrintWriter writer = new PrintWriter(new FileWriter(url));
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line).append("\n");
	            }
	            writer.write(sb.toString());
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public void xuatDuLieuVaoTxt(String url, ArrayList<QLHHModel> ds) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(url))) {
	        StringBuilder sb = new StringBuilder();
	        for (QLHHModel line : ds) {
	            sb.append(line.getId()).append(",")
	              .append(line.getTen()).append(",")
	              .append(line.getGia()).append(",")
	              .append(line.getSoLuong()).append(",")
	              .append(line.getDaNhap()).append(",")
	              .append(line.getNgayNhap()).append(",").append(line.getDaXuat()).append(",").append(line.getNgayXuat()).append("\n");
	        }
	        writer.write(sb.toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public ArrayList<QLHHModel> layDuLieuTuTxt(String url) throws IOException {
	    ArrayList<QLHHModel> result = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
	        reader.lines().forEach(line -> {
	            String[] s = line.split(",");
	            String id = s[0];
	            String ten = s[1];
	            double gia = Double.valueOf(s[2]);
	            int soLuong = Integer.valueOf(s[3]);
	            int daNhap = Integer.valueOf(s[4]);
	            String ngayNhap = s[5];
	            int daXuat=Integer.valueOf(s[6]);
	            String ngayXuat = s[7];
	            
	            QLHHModel clone = new QLHHModel(id, ten, gia, soLuong, daNhap, ngayNhap,daXuat,ngayXuat);
	            result.add(clone);
	        });
	    }
	    return result;
	}
	public void xuatDuLieuVaoTxtNhanVien(String url, String url1) {
		 try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
	            PrintWriter writer = new PrintWriter(new FileWriter(url1));
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line).append("\n");
	            }
	            writer.write(sb.toString());
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}


