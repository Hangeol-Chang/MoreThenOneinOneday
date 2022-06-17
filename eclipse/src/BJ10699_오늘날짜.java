

import java.text.SimpleDateFormat;
import java.util.Date;

public class BJ10699_오늘날짜 {
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat a = new SimpleDateFormat("YYYY-MM-dd");
		String b = a.format(today);
		System.out.println(b);
	}
}