/*
* @author PC
*
*/
package Model;

import java.util.ArrayList;

import javax.swing.JFrame;

	public abstract class AThongKe extends JFrame{
			public ArrayList<QLHHModel> hh;
		public AThongKe(String s, ArrayList<QLHHModel> h) {
		super(s);
		hh=h;
	}
}
