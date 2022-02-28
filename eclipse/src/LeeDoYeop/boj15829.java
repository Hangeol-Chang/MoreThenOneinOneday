package LeeDoYeop;
import java.util.Scanner;

public class boj15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		String str = sc.next();
		int[] arr = new int[L];
		long sum = 0;
		long cnt = 1;
		int M = 1234567891;
		for (int i = 0; i < L; i++) {
			arr[i] = str.charAt(i) - 96;
			sum += arr[i] * cnt;
			cnt = cnt * 31 % M;
		}
		System.out.println(sum % M);
	}
}
