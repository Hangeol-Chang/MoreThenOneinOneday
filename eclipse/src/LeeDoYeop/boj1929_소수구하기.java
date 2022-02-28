package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1929_소수구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for (int i = M; i <= N; i++) {
			int cnt = 0;
			if (i % 2 == 1 && i > 1) {
				for (int j = 1; j <= Math.sqrt(i); j++) {
					if (i % j == 0)
						cnt++;
				}
			}
			if(cnt == 1)
				System.out.println(i);
			if(i == 2)
				System.out.println(i);
		}
	}
}
