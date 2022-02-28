package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1478_소수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			if (num % 2 == 1 && num > 1) {
				for (int j = 1; j <= num; j++) {
					if (num % j == 0)
						cnt++;
				}
			}
			if(cnt == 2)
				ans++;
			if(num == 2)
				ans++;
		}
		System.out.println(ans);
	}
}
