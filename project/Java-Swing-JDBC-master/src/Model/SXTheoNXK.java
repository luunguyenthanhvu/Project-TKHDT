package Model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/

public class SXTheoNXK implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<QLHHModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<QLHHModel>() {
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
	}

}
