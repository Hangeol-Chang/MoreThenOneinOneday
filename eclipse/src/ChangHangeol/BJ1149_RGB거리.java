package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 각 지점을 r,g,b로 칠할 때의 최솟값을 구하기.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		// 0r, 1g, 2b
		int[][] min = new int[N+1][3];
		int[] c = new int[3];
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			c[0] = Integer.parseInt(st.nextToken());
			c[1] = Integer.parseInt(st.nextToken());
			c[2] = Integer.parseInt(st.nextToken());
			
			for(int d = 0; d < 3; d++) { min[i][d] = c[d] + Math.min(min[i-1][(d+1)%3], min[i-1][(d+2)%3]); }
		}
		
		int minv = Math.min(min[N][0], Math.min(min[N][1], min[N][2]));
		System.out.println(minv);
	}
}
