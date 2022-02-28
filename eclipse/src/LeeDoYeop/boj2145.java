package LeeDoYeop;
import java.util.Scanner;

public class boj2145 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num = 0;
		for (;;) {
			int N = sc.nextInt();
			int length = (int) (Math.log10(N) + 1);
			sum = 0;
			if (N == 0 || N>=100000)
				break;
			for (int j = length; j > 0; j--) {
				num = (int) (N / Math.pow(10, j - 1));
				N = (int) (N - num * Math.pow(10, j - 1));
				sum += num;
			}
			if (sum >= 10) {
				sum = sum / 10 + sum % 10;
			}
			if (sum >= 10)
				sum = sum / 10 + sum % 10;
			System.out.println(sum);
		}
	}
}
