
public class FactoryThongKe {
	 public static final AThongKe getThongKe(String input) {
	    if(input.equals("Thong Ke Theo Thoi Gian")) {
	    	return new ThongKeTime("Thong Ke Hang Hoa Theo Thoi Gian",QLHangHoa.getList() );
	    } else {
	    	return new ThongKe("Thong Ke Hang Hoa",QLHangHoa.getList() );
	    }
	    }
	 
	}

