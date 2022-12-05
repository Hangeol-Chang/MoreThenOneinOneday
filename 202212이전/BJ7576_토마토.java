

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576_토마토 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
		
	public static void main(String[] args) throws IOException {
		class location {
			int r;
			int c;
			public location(int r, int c) {
				this.r = r;
				this.c = c;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<location> que = new LinkedList<location>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] box = new int[R][C];
		int count0 = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 0) count0++;
				else if(box[i][j] == 1) que.add(new location(i, j));
			}
		}
		int day = 0;
		while(!que.isEmpty()) {
			day++;
			//이전 날에 입력된 토마토 주변 익히기
			int size = que.size();
			for(int t = 0; t < size; t++) {
				location tomato = que.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = tomato.r + dr[d];
					int nc = tomato.c + dc[d];
					
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && box[nr][nc] == 0) {
						count0--;
						box[nr][nc] = 1;
						que.add(new location(nr, nc));
					}
				}
			}
		}
		System.out.println((count0 == 0) ? (day-1) : -1);
	}
}
