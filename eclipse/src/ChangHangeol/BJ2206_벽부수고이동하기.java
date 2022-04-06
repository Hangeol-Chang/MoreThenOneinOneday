package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 틀렸다 모르겄다.

// 벽을 부술 수 있으면 그냥 1을 밟아버리기.
// 무조건 1,1에서 시작
public class BJ2206_벽부수고이동하기 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class loc{
		int r, c, len,canbreak;
		loc(int r, int c, int len, int cb){ 
			this.r = r; this.c = c; 
			this.len = len;
			this.canbreak = cb; 
		}
	}
	static int M, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M+2][N+2];
		for(int i = 0; i < M+2; i++) {
			map[i][0]   = 2;
			map[i][N+1] = 2;
		}
		for(int i = 0; i < N+2; i++) {
			map[0][i]   = 2;
			map[M+1][i] = 2;
		}
		
		for(int r = 1; r <= M; r++) {
			String ref = br.readLine();
			for(int c = 1; c <= N; c++) {
				map[r][c] = ref.charAt(c-1) - '0';
			}
		}
		Queue<loc> que = new LinkedList<>();
		// 출발 때 길이를 2로 잡고 시작.
		que.add(new loc(1, 1, 2, 1));
		map[1][1] = 1;
		
		while(!que.isEmpty()) {
			loc nowloc = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = nowloc.r + dr[d];
				int nc = nowloc.c + dc[d];
				
				if(map[nr][nc] <= nowloc.canbreak) {
					int tmp = nowloc.canbreak - map[nr][nc];
					
					map[nr][nc] = nowloc.len + 1;
					que.add(new loc(nr, nc, map[nr][nc], tmp));
				}
			}
		}
//		for(int i = 0; i <= M+1; i++) {
//			for(int j = 0; j <= N+1; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(map[M][N]-1);
	}
}
