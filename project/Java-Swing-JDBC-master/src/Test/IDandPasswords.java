package Test;




import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfoAdmin = new HashMap<String,String>();
	IDandPasswords(){
		 logininfoAdmin.put("ThanhVu","123");
		 logininfoAdmin.put("MinhTu","123");
		 logininfoAdmin.put("MinhTuan","123");
	}
	
	public HashMap getLoginInfo(){
		return  logininfoAdmin;
	}
}
