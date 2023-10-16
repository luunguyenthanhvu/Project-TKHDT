/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.View_ThongKeHangHoa;

public class Controller_ThongKe implements ActionListener{
	private View_ThongKeHangHoa view;

	public Controller_ThongKe(View_ThongKeHangHoa view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Cancel")) {
			this.view.dispose();
		}
	}
	
}
