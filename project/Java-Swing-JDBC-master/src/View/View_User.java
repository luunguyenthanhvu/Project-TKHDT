
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.ControlForEditUser;
import Controller.ControlUser;
import Controller.Controller_DangXuatUser;
import Model.HangHoaModelUser;

public class View_User extends JFrame {
	
	private JTextField textField;

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTable table;
	public static ArrayList<HangHoaModelUser> list;
	private ControlUser control;
	private ControlForEditUser control1;
	public static ArrayList<String[]> chuoiNgayXuatVaDaXuat;
	
	
	public static DefaultTableModel model;
	
	

	/**
	 * Create the frame.
	 */
	public View_User() {
		getContentPane().setBackground(new Color(128, 255, 255));
	setSize(1000,1000);
		list = new ArrayList<>();
		getContentPane().setLayout(null);
		
//		Nhập sẵn dữ liệu
		try {
		this.chuoiNgayXuatVaDaXuat=luuChuoiNgayXuatVaDaXuat("danhSachNhapKho.txt");
			list = this.layDuLieuTuTxt("danhSachNhapKho.txt");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		thêm icon
		ImageIcon imageIcon = new ImageIcon("nhanVien.jpg");
		Image image = imageIcon.getImage();
		Image scaledImage = image.getScaledInstance(416, 416, Image.SCALE_SMOOTH); // thay đổi kích thước của hình ảnh
		ImageIcon newIcon = new ImageIcon(scaledImage); // tạo đối tượng ImageIcon mới từ hình ảnh mới
		setIconImage(newIcon.getImage());
		
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 984, 997);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
//		Khởi tạo Bảng
		
	        
	        // Khởi tạo một đối tượng DefaultTableModel
	    this.model = new DefaultTableModel();
	        
	        // Thêm tên cột cho bảng
	        model.addColumn("ID");
	        model.addColumn("Ten");
	        model.addColumn("Gia");
	        model.addColumn("So Luong");
	        model.addColumn("Da Nhap");
	        model.addColumn("Ngay Nhap");
	        
	        // Thêm giá trị cho bảng
	    	for(HangHoaModelUser hh: list) {
				model.addRow(new Object[] {hh.getId(),hh.getTen(),hh.getGia(),
						hh.getSoLuong(),hh.getDaNhap(),hh.getNgayNhap()
						});
			}
	        
	        // Gán model cho JTable
	    	this.table = new JTable(model) {
	    	    @Override
	    	    public boolean isCellEditable(int row, int column) {
	    	        // Không cho phép chỉnh sửa
	    	        return false;
	    	    }
	    	};
	    	
	        
	        
	        // Thêm JTable vào JPanel
	       
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(58, 551, 800, 200);
	        panel.add(scrollPane);
		
		
		
		JLabel lblNewLabel = new JLabel("Nhap Hang Hoa");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(408, 0, 317, 92);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(359, 104, 222, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 156, 222, 31);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(359, 207, 222, 31);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(359, 265, 222, 31);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(359, 322, 222, 31);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(359, 378, 222, 31);
		panel.add(textField_5);
		
		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(133, 111, 55, 16);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ten");
		lblNewLabel_2.setBounds(133, 163, 55, 16);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Gia");
		lblNewLabel_3.setBounds(133, 214, 55, 16);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("So Luong");
		lblNewLabel_4.setBounds(133, 272, 55, 16);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Da Nhap");
		lblNewLabel_5.setBounds(133, 329, 55, 16);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Ngay Nhap");
		lblNewLabel_6.setBounds(133, 385, 74, 16);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Them");
		
		btnNewButton.setBounds(218, 463, 98, 26);
		panel.add(btnNewButton);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(359, 463, 98, 26);
		panel.add(btnXoa);
		
		JButton btnNewButton_1_1 = new JButton("Sua");
		btnNewButton_1_1.setBounds(507, 463, 98, 26);
		panel.add(btnNewButton_1_1);

		control = new ControlUser(this);	
		control1 = new ControlForEditUser(this);
		JButton btnOut = new JButton("Dang Xuat");
		btnOut.setBounds(850, 780, 125, 45);
		btnOut.setBackground(Color.white);
		btnOut.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnOut );
	
	        
//	        add sự kiện
	        this.table.addMouseListener(control);
	        btnNewButton_1_1.addActionListener(control);
	        btnNewButton.addActionListener(control);
	        btnXoa.addActionListener(control);
	        btnOut.addActionListener(new Controller_DangXuatUser(this));
	       
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public ArrayList<HangHoaModelUser> getList() {
		return list;
	}
	public JTable getBang() {
		return this.table;
	}
	public DefaultTableModel getBangModel() {
		return this.model;
	}
	public ControlForEditUser getControlEdit() {
		return control1;
	}
	public ControlUser getControl() {
		return control;
	}
	

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}
	
	public ArrayList<HangHoaModelUser> layDuLieuTuTxt(String url) throws IOException {
	    ArrayList<HangHoaModelUser> result = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(url))) {
	        reader.lines().forEach(line -> {
	            String[] s = line.split(",");
	            String id = s[0];
	            String ten = s[1];
	            String gia = s[2];
	            String soLuong = s[3];
	            String daNhap = s[4];
	            String ngayNhap = s[5];
	            HangHoaModelUser clone = new HangHoaModelUser(id, ten, gia, soLuong, daNhap, ngayNhap);
	            result.add(clone);
	        });
	    }
	    return result;
	}
	
	    
	

	public void xuatDuLieuVaoTxt(String url, ArrayList<HangHoaModelUser> ds,ArrayList<String[]> chuoi) {
		int count = 0;
		
	    try (PrintWriter writer = new PrintWriter(new FileWriter(url))) {
	        StringBuilder sb = new StringBuilder();
	        for (HangHoaModelUser line : ds) {
	        	
	        		
	        		if(count ==chuoi.size()) break;
	        		sb.append(line.getId()).append(",")
		              .append(line.getTen()).append(",")
		              .append(line.getGia()).append(",")
		              .append(line.getSoLuong()).append(",")
		              .append(line.getDaNhap()).append(",")
		              .append(line.getNgayNhap()).append(",").append(chuoi.get(count)[0]).append(",").append(chuoi.get(count)[1]).append("\n");
	        		count++;
	        
	        	
	            
	        }
	       for(int i=chuoi.size(); i<ds.size();i++) {
	    	   sb.append(ds.get(i).getId()).append(",")
	              .append(ds.get(i).getTen()).append(",")
	              .append(ds.get(i).getGia()).append(",")
	              .append(ds.get(i).getSoLuong()).append(",")
	              .append(ds.get(i).getDaNhap()).append(",")
	              .append(ds.get(i).getNgayNhap()).append(",").append(0).append(",").append("null").append("\n");
	         
	       }
	        writer.write(sb.toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	//
	public ArrayList<String[]> luuChuoiNgayXuatVaDaXuat(String url) {
		ArrayList<String[]> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                	
                		String []temp = new String[2];
                		temp[0]=parts[parts.length - 2];
                		temp[1]= parts[parts.length - 1];
                		result.add(temp);
                		
                	
                 
                   
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
		
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_User frame = new View_User();
					frame.setVisible(true);
					
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}