/*
* @author PC
*
*/
package Test;

import java.util.HashMap;

public class IDandPasswordsUsers {
	HashMap<String,String> logininfoUser = new HashMap<String,String>();
	IDandPasswordsUsers(){
		logininfoUser.put("MinhTuong","123");
		logininfoUser.put("ThanhTan","123");
	}
	
	public HashMap getLoginInfo(){
		return  logininfoUser;
	}
}
