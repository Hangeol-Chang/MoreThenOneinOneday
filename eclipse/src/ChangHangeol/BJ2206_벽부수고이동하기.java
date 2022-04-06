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
		int r, c, len;
		boolean canbreak;
		loc(int r, int c, int len, boolean cb){ 
			this.r = r; this.c = c; 
			this.len = len;
			this.canbreak = cb; 
		}
	}
	static int M, N;
	static int dist;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 테두리를 -1로 초기화.
		map = new int[M+2][N+2];
		for(int i = 0; i < M+2; i++) {
			map[i][0]   = -1;
			map[i][N+1] = -1;
		}
		for(int i = 0; i < N+2; i++) {
			map[0][i]   = -1;
			map[M+1][i] = -1;
		}
		// map 입력받기
		for(int r = 1; r <= M; r++) {
			String ref = br.readLine();
			for(int c = 1; c <= N; c++) {
				map[r][c] = ref.charAt(c-1) - '0';
			}
		}
		// 입력받기 끝.
		
		dist = M * N;
		dfs(1, 1, 1, 1);
		
		Queue<loc> que = new LinkedList<>();
		// 출발 때 길이를 2로 잡고 시작.
		que.add(new loc(1, 1, 2, true));
		map[1][1] = 1;
		
		// 벽을 부수지 않고 출구를 찾아보기.
		while(!que.isEmpty()) {
			loc nowloc = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = nowloc.r + dr[d];
				int nc = nowloc.c + dc[d];
				
				if(map[nr][nc] == 0) {
					
					map[nr][nc] = nowloc.len + 1;
					que.add(new loc(nr, nc, map[nr][nc], true));
				}
				// 벽을 부술 수 있는 상황에 대해, 벽을 부수고 그 위치를 넣어만 놓기.
				else if(map[nr][nc] == 1) {
					
				}
			}
		}
		int dist = map[M][N] == 0 ? M*N : map[M][N];
		
		// 벽을 부술 수 있는 모든 경우에 대해.
//		for(int i = 0; i <= M+1; i++) {
//			for(int j = 0; j <= N+1; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(map[M][N]-1);
	}
	public static void dfs(int r, int c, int len, int cb) {
		// 백트래킹 코드
		if(len > dist) return;
		
		// 도착했을때 리턴.
		else if(r == M && c == N) {
			dist = Math.min(dist,  len+1);
			return;
		}
		
		// 4방향에 대해
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[nr][nc] <= cb) {				
				int tmp = map[r][c];
				map[nr][nc] = len;
				dfs(nr, nc, len+1, cb);
				// 되돌려놓기
				map[nr][nc] = tmp;
			}
		}
	}
	
}
/*
6 4
0100
1110
1000
0000
0111
0000

4 4
0111
1111
1111
1110

*/