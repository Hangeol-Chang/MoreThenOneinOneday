package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] map = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int l = 0;
		int r = 0;
		int sum = map[0];
		if(sum >= S) {
			System.out.print(1);
			return;
		}
		int ans = Integer.MAX_VALUE;
		
		while(r < N-1) {
			if(sum < S) { sum += map[++r]; }
			else 		{ sum -= map[l++]; }
			if(sum >= S) {
				ans = Math.min(ans, r-l+1);
				
				if(ans == 1) {
					System.out.println(1);
					return;
				}
			}
//			System.out.println(l + " " + r + " " + "답 : " + ans);
		}
		while(sum >= S && l < r) {
			sum -= map[l++];
			if(sum >= S) {
				ans = Math.min(ans, r-l+1);				
			}
//			System.out.println(l + " " + r + " " + "답 : " + ans);
		}
		System.out.print(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}