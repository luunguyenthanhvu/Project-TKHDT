import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class XoaHangHoa {
	ArrayList<HangHoa> hh;
	DefaultTableModel dataModel;
	int getRow;

	public XoaHangHoa(ArrayList<HangHoa> h, DefaultTableModel model, int row) {
		this.getRow = row;
	    this.hh = h;
	    this.dataModel = model;

	    h.remove(row); 
	    model.removeRow(row);


	    for (int i = row; i < h.size(); i++) {
	        h.get(i).setId(String.valueOf(i + 1));
	        model.setValueAt(h.get(i).getId(), i, 0);
	        model.setValueAt(h.get(i).getTen(), i, 1);
	        model.setValueAt(h.get(i).getGia(), i, 2);
	        model.setValueAt(h.get(i).getSoLuong(), i, 3);
	        model.setValueAt(h.get(i).getDaNhap(), i, 4);
	        model.setValueAt(h.get(i).getNgayNhap(), i, 5);
	        model.setValueAt(h.get(i).getDaXuat(), i, 6);
	        model.setValueAt(h.get(i).getNgayXuat(), i, 7);
	    }
	}
		}