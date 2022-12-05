

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010_다리놓기 {
	static int s, e;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			int[][] map = new int[s+1][e+1];
			// 1에서 출발하는거 전부 1로 맞추기
			for(int i = 0; i <= e; i++) map[1][i] = i;
			
			for(int r = 2; r <= s; r++) {
				for(int c = r; c <= e; c++) {
					int tmp = 0;
					for(int i = c-1; i >= r-1; i--) tmp += map[r-1][i];
//					System.out.println(r + " " + c);
					map[r][c] = tmp;
				}
			}
			
			sb.append(map[s][e]+"\n");
		}
		System.out.println(sb);
	}
	public static void run(int connect, int rinked) {
		if(connect == s) {
			count++;
			return;
		}
		
		for(int i = rinked+1; i < e-s+connect+1; i++) {
			run(connect+1, i);
		}
	}
}
