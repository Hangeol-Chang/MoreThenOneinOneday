

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과

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
		
		// 테두리를 2로 초기화.
		map = new int[M][N];
		// map 입력받기
		for(int r = 0; r < M; r++) {
			String ref = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = ref.charAt(c) - '0';
			}
		}
		// 입력받기 끝.
		
		dist = M * N;
		// 출발 때 길이를 2로 잡고 시작.
		map[0][0] = 2;
		dfs(0, 0, 2, 1);
		
		System.out.println(dist == M*N ? -1 : dist-1);
	}
	public static void dfs(int r, int c, int len, int cb) {
		// 백트래킹 코드
		if(len > dist) return;
		
		// 도착했을때 리턴.
		else if(r == M-1 && c == N-1) {
			dist = Math.min(dist,  len);
			return;
		}
		
		// 4방향에 대해
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] <= cb) {
				int tmp = map[nr][nc];
				map[nr][nc] = len;

//				System.out.println("\n" + nr + " " + nc);
//				for(int i = 0; i < M; i++) {
//					for(int j = 0; j < N; j++) {
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
				
				dfs(nr, nc, len+1, cb-tmp);
				
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