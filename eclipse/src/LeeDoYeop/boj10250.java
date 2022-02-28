package LeeDoYeop;
import java.util.Scanner;

public class boj10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			if (H * W >= N && H != 1 && N != 0 && W < 100) {
				if (N % H != 0)
					System.out.printf("%d\n", ((N % H) * 100) + (N / H) + 1);
				else
					System.out.printf("%d\n", H * 100 + ((N / H)));
			} else if (H * W >= N && H == 1 && N != 0 && W < 100) {
				if (N % H != 0)
					System.out.printf("%d\n", (N % H) * 100 + (N / H));
				else
					System.out.printf("%d\n", H * 100 + (N / H));
			}
		}
	}
}
