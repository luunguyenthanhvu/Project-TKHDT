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

public class SXTheoNNK implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<HangHoa> hh) {
		// TODO Auto-generated method stub
		 Collections.sort(hh, new Comparator<HangHoa>() {
		        DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		        public int compare(HangHoa h1, HangHoa h2) {
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
