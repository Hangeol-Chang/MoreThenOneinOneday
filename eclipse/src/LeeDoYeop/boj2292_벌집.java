package LeeDoYeop;
import java.util.Scanner;

public class boj2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		int sum = 1;
		int N = sc.nextInt();
		for (int i = 1;; i++) {
			cnt++;
			sum += i * 6;
			if (N == 1) {
				cnt = 1;
				break;
			}
			if (sum >= N)
				break;
		}
		System.out.println(cnt);
	}
}
