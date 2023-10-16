



import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		logininfo.put("ThanhVu","123");
		logininfo.put("MinhTu","123");
		logininfo.put("MinhTuan","123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}
