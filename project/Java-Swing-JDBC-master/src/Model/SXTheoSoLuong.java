package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SXTheoSoLuong implements SXStrategy {

	@Override
	public <T> void sort(ArrayList<QLHHModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<QLHHModel>() {
			public int compare(QLHHModel h1, QLHHModel h2) {
				Integer s1 = h1.getSoLuong();
				Integer s2 = h2.getSoLuong();
				return s1.compareTo(s2);
			}
		});
		
	}

}
