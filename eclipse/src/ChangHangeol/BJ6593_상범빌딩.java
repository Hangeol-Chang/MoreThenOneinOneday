package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * . # S E 네개로 입력 들어옴.
 */
public class BJ6593_상범빌딩 {
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static class loc {
		int h, r, c, dist;
		loc(int h, int r, int c, int dist){
			this.h = h;
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String ref = "#.SE";
		
		test : while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(H+R+C == 0) break;
			
			Queue<loc> que = new LinkedList<>();
			int[][][] map = new int[H+2][R+2][C+2];
			for(int h = 1; h <= H; h++ ) {
				for(int r = 1; r <= R; r++) {
					String li = br.readLine();
					for(int c = 1; c <= C; c++) {
						map[h][r][c] = ref.indexOf(li.charAt(c-1));
						
						// 시작위치
						if(map[h][r][c] == 2)
							que.add(new loc(h, r, c, 0));
					}
				}
				br.readLine();	// 한줄 버리기.
			}
			// 입력완료
			
			// 1인 지점들만 갈 수 있음.
			while(!que.isEmpty()) {
				loc now = que.poll();
				
				for(int d = 0; d < 6; d++) {
					int nh = now.h + dh[d];
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(map[nh][nr][nc] == 3) {
						sb.append("Escaped in " + (now.dist+1) + " minute(s).\n");
						continue test;
					}
					
					if(map[nh][nr][nc] == 1) {
						map[nh][nr][nc] = 0;
						que.add(new loc(nh, nr, nc, now.dist + 1));
					}
				}
			}
			sb.append("Trapped!\n");
		}
		System.out.println(sb);
	}
}
