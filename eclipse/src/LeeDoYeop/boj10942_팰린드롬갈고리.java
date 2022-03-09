package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10942_팰린드롬갈고리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken())-1;
			int E = Integer.parseInt(st.nextToken())-1;
			int ans = 1;
			while(S <= E) {
				if(num[S] == num[E]) {
					S++;
					E--;
				}else {
					ans = 0;
					break;
				}
					
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
