package LeeDoYeop;
import java.util.Scanner;

public class boj2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = -1;
		for (int i = 0; i <= N / 5; i++) {
			for (int j = 0; j <= N / 3; j++) {
				if (5 * i + j * 3 == N) {
					result = 0;
					result = i + j;
				}
			}
		}
		System.out.println(result);
	}
}
