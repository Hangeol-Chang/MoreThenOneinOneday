

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// dp
public class SWEA1249_보급로 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class loc implements Comparable<loc> {
		int r, c;
		int w;
		loc(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(loc o) {
			return this.w - o.w;
		}
	}
	static int[][] map;
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			for(int i = 0; i <= N+1; i++) Arrays.fill(map[i], 10);
			visited = new boolean[N+2][N+2];
			
			for(int i = 1; i <= N; i++) {
				String ref = br.readLine().toString();
				for(int j = 1; j <= N; j++)			
					map[i][j] = ref.charAt(j-1) - '0';
			}
			// 입력 완.
			
			int ans = N*N*9;
			PriorityQueue<loc> pq = new PriorityQueue<>();
			pq.add(new loc(1, 1, 0));
			while(!pq.isEmpty()) {
				loc now = pq.poll();
				
				// 방문처리 & 백트래킹
				if(visited[now.r][now.c] || ans < now.w) continue;
				// 목표에 도달.
				if(now.r == N && now.c == N) {
					ans = Math.min(ans, now.w);
					continue;
				}
				visited[now.r][now.c] = true;
				
				// 주변을 큐에 넣기.
				for(int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(visited[nr][nc] || map[nr][nc] == 10) continue;
					
					pq.add(new loc(nr, nc, now.w + map[nr][nc]));
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}

/*

1
4
0100
1110
1011
1010

*/