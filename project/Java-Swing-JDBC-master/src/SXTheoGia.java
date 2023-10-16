import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/

public class SXTheoGia implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<HangHoa> hh) {
		// TODO Auto-generated method stub
		Collections.sort(hh, new Comparator<HangHoa>() {
			public int compare(HangHoa h1, HangHoa h2) {
				Double g1 = Double.valueOf(h1.getGia());
				Double g2 = Double.valueOf(h2.getGia());
				return g1.compareTo(g2);
			}
		});
		
	}
	
}
