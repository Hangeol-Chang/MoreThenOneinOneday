package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2581_소수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = 10000;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			int cnt = 0;
			if (i % 2 == 1 && i > 1) {
				for (int j = 1; j <= Math.sqrt(i); j++) {
					if (i % j == 0)
						cnt++;
				}
			}
			if (cnt == 1 || i == 2) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		if (sum == 0 && min == 10000)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
