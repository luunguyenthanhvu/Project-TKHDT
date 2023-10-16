/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.QLHHModel;
import View.View_ThongKeHangHoaTime;

public class Controller_ThongKeTime implements ActionListener {
	private View_ThongKeHangHoaTime view;

	public Controller_ThongKeTime(View_ThongKeHangHoaTime view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			
			String timeB = view.time1.getText();
			String timeE = view.time2.getText();
			Date timeBegin = null,timeEnd = null;
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			try {	
				timeBegin = format.parse(timeB);
				timeEnd = format.parse(timeE);
			} catch (ParseException o) {
				o.printStackTrace();
			}	
			if(timeBegin.before(timeEnd)) {
				 Collections.sort(view.hh, new Comparator<QLHHModel>() {
				        DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
				        public int compare(QLHHModel h1, QLHHModel h2) {
				        	String o1 = new String(h1.getNgayNhap());
				        	String o2 = new String(h2.getNgayNhap());
				            try {
				                return f.parse(o1).compareTo(f.parse(o2));
				            } catch (ParseException e) {
				                throw new IllegalArgumentException(e);
				            }
				        }
				    });
				 for (QLHHModel k : view.hh) {
						{
							Date cloneN;
							try {
								cloneN = format.parse(k.getNgayNhap());							
								if(timeBegin.before(cloneN)&&cloneN.before(timeEnd)) {
									view.dataNhap.addRow(new Object[] {
											k.getTen(),k.getSoLuong(),k.getNgayNhap()
									});
									view.tbNhap.setModel(view.dataNhap);
								}															
							}catch (ParseException o) {
								o.printStackTrace();
							}
						}
					}
				 Collections.sort(view.hh, new Comparator<QLHHModel>() {
				        DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
				        public int compare(QLHHModel h1, QLHHModel h2) {
				        	String o1 = new String(h1.getNgayXuat());
				        	String o2 = new String(h2.getNgayXuat());
				            try {
				                return f.parse(o1).compareTo(f.parse(o2));
				            } catch (ParseException e) {
				                throw new IllegalArgumentException(e);
				            }
				        }
				    });
				 for (QLHHModel k : view.hh) {
						{
							Date cloneX;
							try {
								cloneX = format.parse(k.getNgayXuat());							
								if(timeBegin.before(cloneX)&&cloneX.before(timeEnd)) {
									view.dataXuat.addRow(new Object[] {
											k.getTen(),k.getSoLuong(),k.getNgayXuat()
									});
									view.tbXuat.setModel(view.dataXuat);
								}															
							}catch (ParseException o) {
								o.printStackTrace();
							}
						}
					}
				 for ( QLHHModel k : view.hh) {
						{
							Date cloneN,cloneX;
							try {
								cloneN = format.parse(k.getNgayNhap());
								cloneX = format.parse(k.getNgayXuat());
								
								if(timeBegin.before(cloneN)&&cloneN.before(timeEnd)) {
									view.dataNhap.addRow(new Object[] {
											k.getTen(),k.getSoLuong(),k.getNgayNhap()
									});
									view.tbNhap.setModel(view.dataNhap);
								}
								if(timeBegin.before(cloneX)&&cloneX.before(timeEnd)) {
									view.dataXuat.addRow(new Object[] {
											k.getTen(),k.getSoLuong(),k.getNgayXuat()
									});
									view.tbXuat.setModel(view.dataXuat);
								}
								
								
							}catch (ParseException o) {
								o.printStackTrace();
							}
						}
					}
				JOptionPane.showMessageDialog(view.rootPane, "Thong ke Thanh Cong!");
			}
			else
				JOptionPane.showMessageDialog(view.rootPane, "Loi! Ngay bat dau > Ngay ket thuc");
		}
		else if (e.getActionCommand().equals("Refresh")) {
			this.view.dispose();
			new View_ThongKeHangHoaTime("Thong Ke Hang Hoa Theo Thoi Gian", view.hh);
		}
		else if (e.getActionCommand().equals("Cancel"))
			this.view.dispose();
	
	
}
}
