package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class BJ4485_녹색옷입은애가젤다지 {
	static class node implements Comparable<node>{
		int r, c, w;
		node(int r, int c, int w){
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		roop : do {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][];
			for(int i = 0; i < N; i++)
				map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 입력완료.
			
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.add(new node(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				node now = pq.poll();
				if(now.r == N-1 && now.c == N-1) {
					sb.append("Problem " + tc++ + ": " + now.w + "\n");
					continue roop;
				}
				
				if(visited[now.r][now.c]) continue;
				visited[now.r][now.c] = true;
				
				for(int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					pq.add(new node(nr, nc, now.w + map[nr][nc]));
				}
			}
		}while(true);
		System.out.println(sb);
	}
}
