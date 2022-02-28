package LeeDoYeop;
import java.util.Scanner;

public class boj2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int max = 10;
		int sum;
		int[] jack = new int[N];
		for (int i = 0; i < N; i++) {
			jack[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = jack[i] + jack[j] + jack[k];
					if (sum <= M && max < sum)
						max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
