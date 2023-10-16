package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* @author PC
*
*/


public class SXTheoTen implements SXStrategy{

	@Override
	public <T> void sort(ArrayList<QLHHModel> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator<QLHHModel>() {
			public int compare(QLHHModel h1, QLHHModel h2) {
				return h1.getTen().compareTo(h2.getTen());
			}
		});
	}

}
