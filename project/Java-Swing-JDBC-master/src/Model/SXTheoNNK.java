package Model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SXTheoNNK implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<QLHHModel> list) {
		// TODO Auto-generated method stub
		 Collections.sort(list, new Comparator<QLHHModel>() {
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
		
	}

}
