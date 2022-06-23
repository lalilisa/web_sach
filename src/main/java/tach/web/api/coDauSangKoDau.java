package tach.web.api;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class coDauSangKoDau {
	public static String ChuanHoa(String coDau) {
		 String koDau = Normalizer.normalize(coDau.trim().toLowerCase(), Normalizer.Form.NFD);
		    koDau = koDau.replaceAll("đ", "d");
		    koDau = koDau.replaceAll("[^\\p{ASCII}]", "");
		    koDau=koDau.replaceAll("\\s+", "-");
		    return koDau;
	}
	public static void main(String args[]) {
		String s="11111111";
		if(s.matches("\\d+"))
			System.out.println("tri");
		else {
			System.out.println("ngu");
		}
		String ss="/s/s";
		String luu[]=ss.split("/");
		for(String i: luu)
				System.out.println(i);
//		Date date = Calendar.getInstance().getTime();  
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");  
//		String strDate = dateFormat.format(date);  
//		System.out.println(strDate);

	}
}
