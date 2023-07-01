

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// dfs
public class BJ14500_테트로미노 {
	static int N, M;
	static int maxsum;
	static int[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][];
		
		for(int i = 0; i < N; i++)
			map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 입력 끝.
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				int tmp = map[i][j];
				map[i][j] = 0;
				dfs(i, j, 1, tmp);
				map[i][j] = tmp;
				
				burf(i, j);
			}
		
		System.out.println(maxsum);
	}
	static void dfs(int r, int c, int sel, int sum) {
		if(sel == 4) {
			maxsum = Math.max(sum, maxsum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;
			
			int tmp = map[nr][nc];
			map[nr][nc] = 0;
			dfs(nr, nc, sel + 1, sum + tmp);
			
			map[nr][nc] = tmp;
		}
	}
	
	static void burf(int r, int c) {
		t : for(int m = 0; m < 4; m++) {
			int tmpsum = map[r][c];
			for(int d = 0; d < 4; d++) {
				
				if (m == d) continue;
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue t;
				tmpsum += map[nr][nc];
			}
			maxsum = Math.max(tmpsum, maxsum);
		}
	}
}
