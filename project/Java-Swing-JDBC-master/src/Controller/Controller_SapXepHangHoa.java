/*
* @author PC
*
*/
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Test.LoginPage;
import View.View_SapXepHangHoa;

public class Controller_SapXepHangHoa implements ActionListener{
	private View_SapXepHangHoa view;

	public Controller_SapXepHangHoa(View_SapXepHangHoa view) {
		super();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancel")) {
			this.view.dispose();
		}
	}
}
