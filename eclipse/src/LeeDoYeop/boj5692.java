package LeeDoYeop;
import java.util.Scanner;

public class boj5692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		int i;
		int sum;
		int num;
		for (;;) {
			i = sc.nextInt();
			length = (int) (Math.log10(i) + 1);
			sum = 0;
			if (i == 0)
				break;
			for (int j = length; j > 0; j--) {
				num = (int) (i / Math.pow(10, j - 1));
				i = (int) (i - num * Math.pow(10, j - 1));
				sum += num * f(j);
			}
			System.out.println(sum);

		}

	}

	public static int f(int n) {
		if (n == 1)
			return 1;
		else
			return f(n - 1) * n;
	}
}
