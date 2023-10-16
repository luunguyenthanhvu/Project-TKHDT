
import java.util.ArrayList;

import javax.swing.JFrame;

public abstract class AThongKe extends JFrame  {
protected ArrayList<HangHoa> hh;
public AThongKe(String s, ArrayList<HangHoa> h) {
	super(s);
	hh=h;
}


}
