

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468_안전영역 {
	static class loc{
		int r, c;
		loc(int r, int c){
			this.r = r; this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int block;
	
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		int maxt = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxt = Math.max(map[i][j], maxt);
			}
		}
		// 입력받기 끝.
		
		block = 1;
		for(int i = 1; i <= maxt; i++) {
			int[][] map2 = new int[N+2][N+2];
			for(int r = 1; r <= N; r++)
				for(int c = 1; c <= N; c++) {
					if(map[r][c] <= i) map2[r][c] = 0;
					else map2[r][c] = 1;
				}
			
			int blocktmp = 0;
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(map2[r][c] == 0) continue;
					
					Queue<loc> que = new LinkedList<>();
					que.add(new loc(r, c));
					map2[r][c] = 0;
					
					while(!que.isEmpty()) {
						loc location = que.poll();
						
						for(int d = 0; d < 4; d++) {
							int nr = location.r + dr[d];
							int nc = location.c + dc[d];
							
							if(map2[nr][nc] != 0) {
								map2[nr][nc] = 0;
								que.add(new loc(nr, nc));
							}
						}
					}
					blocktmp++;
				}
			}
			block = Math.max(block, blocktmp);
		}
		System.out.println(block);
	}
}
