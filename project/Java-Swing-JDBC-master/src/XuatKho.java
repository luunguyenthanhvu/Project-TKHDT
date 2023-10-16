import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class XuatKho extends JFrame implements ActionListener{
	JPanel p1,p2;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	DefaultTableModel dataModel;
	
	JDateChooser ng;
	public XuatKho(String s,  DefaultTableModel model) {
		super(s);
		dataModel = model;
		
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
		b1.addActionListener(this);
		b2 = new JButton("Cancel");
		b2.addActionListener(this);
		p2.add(b1);
		p2.add(b2);
		this.add(p2,"South");
		setSize(350,250);
		setLocation(525,350);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			int id = Integer.valueOf(t1.getText());
			int soLuong = Integer.valueOf(t2.getText());
			//String ngayXuat = t3.getText();
			DateFormat gg = new SimpleDateFormat("dd-MM-yyyy");
			
			String ngayXuat = gg.format(ng.getDate());
			
			if(QLHangHoa.getList().get(id-1).getId().equals(String.valueOf(id)) 
						&& (QLHangHoa.getList().get(id-1).getSoLuong()>=soLuong)) {
				
				QLHangHoa.getList().set(id-1, new HangHoa(QLHangHoa.getList().get(id-1).getId()
							, QLHangHoa.getList().get(id-1).getTen(), QLHangHoa.getList().get(id-1).getGia()
							, QLHangHoa.getList().get(id-1).getSoLuong()-soLuong
							, QLHangHoa.getList().get(id-1).getDaNhap(),QLHangHoa.getList().get(id-1).getNgayNhap()
							, QLHangHoa.getList().get(id-1).getDaXuat()+soLuong, ngayXuat));
					this.dataModel.insertRow(id-1, new Object[] {QLHangHoa.getList().get(id-1).getId(),QLHangHoa.getList().get(id-1).getTen()
							,QLHangHoa.getList().get(id-1).getGia(),QLHangHoa.getList().get(id-1).getSoLuong()
							,QLHangHoa.getList().get(id-1).getDaNhap(),QLHangHoa.getList().get(id-1).getNgayNhap()
							,QLHangHoa.getList().get(id-1).getDaXuat(),QLHangHoa.getList().get(id-1).getNgayXuat()
					});
					this.dataModel.removeRow(id);
					this.dataModel.fireTableDataChanged();
					JOptionPane.showMessageDialog(rootPane, "Xuat hang hoa thanh cong!");
					this.dispose();
				
			}
			else JOptionPane.showMessageDialog(rootPane, "Khong co hang hoa trong kho!");
		}
		else 
			if(e.getActionCommand().equals("Cancel")) {
				this.dispose();
			}
	}

}
