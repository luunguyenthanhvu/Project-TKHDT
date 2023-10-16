package Model;

import View.View_QLHangHoaAdmin;
import View.View_ThongKeHangHoa;
import View.View_ThongKeHangHoaTime;

public class FactoryThongKe {
	 public static final AThongKe getThongKe(String input) {
	    if(input.equals("Thong Ke Theo Thoi Gian")) {
	    	return new View_ThongKeHangHoaTime("Thong Ke Hang Hoa Theo Thoi Gian",View_QLHangHoaAdmin.getList() );
	    } else {
	    	return new View_ThongKeHangHoa("Thong Ke Hang Hoa",View_QLHangHoaAdmin.getList() );
	    }
	    }
	 
	}

