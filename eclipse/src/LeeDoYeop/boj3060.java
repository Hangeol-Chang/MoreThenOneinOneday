package LeeDoYeop;
import java.util.Scanner;

public class boj3060 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] pigs = new int[6];
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int count = 1;
			int sum = 0;
			for (int j = 0; j < 6; j++) {
				pigs[j] = sc.nextInt();
				sum += pigs[j];
			}
			while (sum <= N) {
				sum *= 4;
				count++;
			}
			System.out.println(count);
		}
	}
}
