

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다시 풀어볼 것.

// 벽을 부술 수 있으면 그냥 1을 밟아버리기.
// 무조건 1,1에서 시작
public class BJ2206_벽부수고이동하기2 {
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
	static int[][] map;
	static int[][] dist;
	static boolean[][][] vi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 테두리를 2로 초기화.
		map = new int[M][N];
		vi = new boolean[2][M][N];
		dist = new int[M][N];
		// map 입력받기
		for(int r = 0; r < M; r++) {
			String ref = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = ref.charAt(c) - '0';
			}
		}
		// 입력받기 끝.
		// 출발 때 길이를 2로 잡고 시작.
		vi[0][0][0] = true;
		vi[1][0][0] = true;
		Queue<loc> que = new LinkedList<>();
		que.add(new loc(0, 0, 2, true));
		
		while(!que.isEmpty()) {
			loc nowloc = que.poll();
			if(nowloc.r == M-1 && nowloc.c == N-1) {
				System.out.println(nowloc.len - 1);
				return;
			}
//			
//			System.out.println(nowloc.r + " " + nowloc.c);
//			for(int i = 0; i < M; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.printf("%3d ",dist[i][j]);
//				}
//				System.out.print("||");
//				for(int j = 0; j < N; j++) {
//					System.out.printf("%3d ", map[i][j]);
//				}				
//				System.out.println();
//			}
//			
			for(int d = 0; d < 4; d++) {
				int nr = nowloc.r + dr[d];
				int nc = nowloc.c + dc[d];
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				
				// 벽을 만났을 때
				if(map[nr][nc] == 1) {
					// 벽을 부실 수 없으면 다음꺼로 넘어감.
					// 이 벽을 부신 적이 있다면 넘어감.
					if(!nowloc.canbreak || vi[1][nr][nc]) continue;
					vi[1][nr][nc] = true;
					
					dist[nr][nc] = nowloc.len + 1;
					que.add(new loc(nr, nc, nowloc.len+1, false));
				}
				// 벽이 아닐때
				else {
					int idx = nowloc.canbreak? 0 : 1;
					if(vi[idx][nr][nc]) continue;
					vi[idx][nr][nc] = true;
					
					dist[nr][nc] = nowloc.len+1;
					que.add(new loc(nr, nc, nowloc.len+1, nowloc.canbreak));
				}
			}
		}
		System.out.println(-1);
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

10 10
0000010000
1111010101
1111000101
1111111101
1111111001
1111111011
1111000011
0000000011
0111111111
0000000000

4 4
0111
1111
1111
1110

*/