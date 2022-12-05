import java.time.LocalDate;
import java.time.ZoneId;

public class BJ10699_오늘날짜 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));
		System.out.print(today);
	}
}