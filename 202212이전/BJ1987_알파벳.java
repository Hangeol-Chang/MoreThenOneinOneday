

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int R, C;
	static int maxrun = 0;
	public static boolean[] visited = new boolean[26];
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			String ref = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = ref.charAt(j) - 'A';
		}
		
		visited[map[0][0]] = true;
		run(0, 0, 1);
		
		System.out.print(maxrun);
	}
	public static void run(int r, int c, int len) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			// 더 갈 수 없으면 비교
			if(visited[map[nr][nc]]) {
				maxrun = Math.max(len, maxrun);
				continue;
			}
			
			visited[map[nr][nc]] = true;
			run(nr, nc, len+1);
			visited[map[nr][nc]] = false;
		}
	}
}