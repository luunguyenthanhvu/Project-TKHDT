import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/

public class SXTheoSoLuong implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<HangHoa> hh) {
		// TODO Auto-generated method stub
		Collections.sort(hh, new Comparator<HangHoa>() {
			public int compare(HangHoa h1, HangHoa h2) {
				Integer s1 = h1.getSoLuong();
				Integer s2 = h2.getSoLuong();
				return s1.compareTo(s2);
			}
		});
		
	}

}
