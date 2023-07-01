
import java.util.Scanner;

/*
 * n-1에 도착 + n-2꺼 + n-3꺼
 */

public class BJ9095_123더하기 {
	static int count = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			count = 0;
			int goal = in.nextInt();
			summing(0, goal);
			sb.append(count + "\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	public static void summing(int sum, int goal) {
		if(sum == goal) {
			count++;
			return;
		}else if(sum > goal) {
			return;
		}else {
			summing(sum+1, goal);
			summing(sum+2, goal);
			summing(sum+3, goal);
		}
	}
}
