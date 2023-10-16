package View;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.ControlForEditUser;
import Model.HangHoaModelUser;

public class ViewSuaThongTinUser extends JFrame   {

	private JPanel contentPane;
	private JTextField textField;
	

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int row;
	private ArrayList<HangHoaModelUser> list;
	private ControlForEditUser control;
	private View_User view;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	public ViewSuaThongTinUser( ArrayList<HangHoaModelUser>hh ,int row, View_User view) {
		this.row=row;
		this.list=hh;
		this.view=view;
	    this.control = this.view.getControlEdit();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("Chinh Sua ThongTin");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField(String.valueOf(list.get(row).getId()));
		textField.setBounds(178, 11, 200, 20);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(String.valueOf(list.get(row).getTen()));
		textField_1.setColumns(10);
		textField_1.setBounds(178, 53, 200, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField(String.valueOf(list.get(row).getGia()));
		textField_2.setColumns(10);
		textField_2.setBounds(178, 98, 200, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField(String.valueOf(list.get(row).getSoLuong()));
		textField_3.setColumns(10);
		textField_3.setBounds(178, 141, 200, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField(String.valueOf(list.get(row).getDaNhap()));
		textField_4.setColumns(10);
		textField_4.setBounds(178, 184, 200, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField(String.valueOf(list.get(row).getNgayNhap()));
		textField_5.setColumns(10);
		textField_5.setBounds(178, 230, 200, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 12, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTen = new JLabel("Ten");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTen.setBounds(86, 56, 46, 14);
		panel.add(lblTen);
		
		JLabel lblGia = new JLabel("Gia");
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGia.setBounds(86, 101, 46, 14);
		panel.add(lblGia);
		
		JLabel lblSoluong = new JLabel("SoLuong");
		lblSoluong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoluong.setBounds(86, 144, 75, 17);
		panel.add(lblSoluong);
		
		JLabel lblDanhap = new JLabel("DaNhap");
		lblDanhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhap.setBounds(86, 187, 75, 17);
		panel.add(lblDanhap);
		
		JLabel lblNgaynhap = new JLabel("NgayNhap");
		lblNgaynhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgaynhap.setBounds(86, 233, 75, 17);
		panel.add(lblNgaynhap);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(122, 281, 89, 23);
		btnNewButton.addActionListener(control);
		panel.add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setBounds(224, 281, 89, 23);
		panel.add(btnCancle);
		btnCancle.addActionListener(control);
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	public int getRow() {
		return row;
	}
	public String getTextField() {
		return textField.getText();
	}


	public String getTextField_1() {
		return textField_1.getText();
	}


	public String getTextField_2() {
		return textField_2.getText();
	}


	public String getTextField_3() {
		return textField_3.getText();
	}


	public String getTextField_4() {
		return textField_4.getText();
	}


	public String getTextField_5() {
		return textField_5.getText();
	}
	
public ArrayList<HangHoaModelUser> getDanhSach() {
	return list;
}
public void setControl(ControlForEditUser cs) {
	this.control=cs;
}
}
