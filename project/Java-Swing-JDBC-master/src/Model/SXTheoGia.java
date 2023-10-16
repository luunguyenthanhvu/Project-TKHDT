package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/

public class SXTheoGia implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<QLHHModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<QLHHModel>() {
			public int compare(QLHHModel h1, QLHHModel h2) {
				Double g1 = Double.valueOf(h1.getGia());
				Double g2 = Double.valueOf(h2.getGia());
				return g1.compareTo(g2);
			}
		});
		
	}
	
}
