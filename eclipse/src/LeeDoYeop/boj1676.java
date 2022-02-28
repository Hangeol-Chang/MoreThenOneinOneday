package LeeDoYeop;
import java.util.Scanner;

public class boj1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = N/5 + N/25 + N/125;
		System.out.println(ans);
	}
}
