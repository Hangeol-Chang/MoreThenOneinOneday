package Making;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M220423_test2 {
	static class loc {
		int r, c, cost, dist;
		loc(int r, int c, int cost, int dist){
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] dr = {0, 1};
		int[] dc = {1, 0};
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			// 최소거리 바로 알 수 있음.
			int dist = N*2 - 2;

			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			// 입력 완료
			
			int maxd = 0;
			Queue<loc> que = new LinkedList<>();
			que.add(new loc(0, 0, 0, 0));
			while(!que.isEmpty()) {
				loc now = que.poll();
				
				// bfs기 때문에, 하나라도 최대거리를 넘어가면 그냥 끝내버려도 됨.
				if(now.dist > dist) break;
				
				if(now.r == N-1 && now.c == N-1) {
					maxd = Math.max(maxd, now.cost);
					continue;
				}
				
				for(int d = 0; d < 2; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(nr >= N || nc >= N) continue;
					
					que.add(new loc(nr, nc, now.cost + map[nr][nc], now.dist+1));
				}
			}
			sb.append("#" + t + " "  + dist + " " + maxd + "\n");
		}
		System.out.println(sb);
	}
}
