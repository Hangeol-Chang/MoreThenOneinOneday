package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16953_A_B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 1;
		for (;a<b;) {
			if (b % 2 == 0)
				b /= 2;
			else if (b % 10 == 1)
				b /= 10;
			else
				break;
			cnt++;
		}
		if (a != b)
			cnt = -1;
		System.out.println(cnt);
	}
}
