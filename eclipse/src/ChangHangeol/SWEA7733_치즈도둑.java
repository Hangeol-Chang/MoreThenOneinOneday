package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 100일동안 치즈를 갉아먹음.
 * x번쨰 날에, 맛이 x인 칸을 먹음.
 * 100일동안 먹을건데, 덩어리가 가장 많을 때는?
 */
public class SWEA7733_치즈도둑 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			int maxt = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}
	public void 
}
