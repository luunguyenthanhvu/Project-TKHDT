import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/


public class SXTheoTen implements SXStrategy{

	@Override
	public <T> void sort(ArrayList<HangHoa> hh) {
		// TODO Auto-generated method stub
		Collections.sort(hh, new Comparator<HangHoa>() {
			public int compare(HangHoa h1, HangHoa h2) {
				return h1.getTen().compareTo(h2.getTen());
			}
		});
	}

}
