package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2475_검증수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		for (int i = 0; i < 5; i++)
			ans += Math.pow(Integer.parseInt(st.nextToken()), 2);
		ans %= 10;
		System.out.println(ans);
	}
}
