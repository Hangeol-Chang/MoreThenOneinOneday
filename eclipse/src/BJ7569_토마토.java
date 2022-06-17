

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569_토마토 {
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dd = {0, 0, 0, 0, -1, 1};
	
	static class location{
		int r, c, d;
		public location(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<location> que = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[R][C][D];
		int count0 = 0;
		for(int d = 0; d < D; d++) {
			for(int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < C; c++) {
					box[r][c][d] = Integer.parseInt(st.nextToken());
					
					if	   (box[r][c][d] == 0) count0++;
					else if(box[r][c][d] == 1) que.add(new location(r, c, d));
				}
			}
		}
		// 입력받기 끝.
		
		int day = 0;
		while(!que.isEmpty()) {
			day++;
			// 이전 날에 입력되어있던 토마토 근처 익히기
			int size = que.size();
			for(int t = 0; t < size; t++) {
				location tmt = que.poll();
				
				for(int delta = 0; delta < 6; delta++) {
					int nr = tmt.r + dr[delta];
					int nc = tmt.c + dc[delta];
					int nd = tmt.d + dd[delta];
					
					if(nr >= 0 && nc >= 0 && nd >= 0 &&
					   nr <  R && nc <  C && nd <  D && box[nr][nc][nd] == 0) {
						count0--;
						box[nr][nc][nd] = 1;
						que.add(new location(nr, nc, nd));
					}
				}
			}
		}
		System.out.println((count0 == 0) ? (day-1) : -1);
	}
}
