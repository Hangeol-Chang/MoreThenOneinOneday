

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA10726_이진수표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		outer : for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < k; i++) {
				// 뒷자리부터 뒤져서, 하나라도 0이면
				// off 추가하고 바로 다음 테케로 넘어감.
				if((n & 1<<i) == 0) {
					sb.append("OFF\n");
					continue outer;
				}
			}
			// 여기까지 오면 통과한거.
			sb.append("ON\n");
		}
		System.out.println(sb);
	}
}
