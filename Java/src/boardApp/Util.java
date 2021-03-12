package boardApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String getNowDate() {
		
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
		
		Date time = new Date();
		
		String reg = format1.format(time);
		
		return reg;
	}
}
