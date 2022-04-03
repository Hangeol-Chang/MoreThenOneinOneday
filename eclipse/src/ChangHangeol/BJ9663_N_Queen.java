package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663_N_Queen {
	static int N, count;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		boolean[][] board = new boolean[N][N];
		queen(0, board);
		
		System.out.println(count);
	}
	private static void queen(int num, boolean[][] boardref) {
		if(num == N) {
			count++;
			return;
		}
		
		for(int j = 0; j < N; j++) {
			if(boardref[num][j] == true) continue;
			
			// 깊은복사
			boolean[][] board = new boolean[N][N];
			
			for(int r = 0; r < N; r++)
				for(int c = 0; c < N; c++)
					board[r][c] = boardref[r][c];
			
			// 퀸 놓기
			board[num][j] = true;
			
			// 퀸이 움직일 수 있는 범위 전부 칠하기.
			for(int d = 0; d < 8; d++) {
				int nr = num + dr[d];
				int nc = j   + dc[d];
				
				while(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					board[nr][nc] = true;
					nr += dr[d];
					nc += dc[d];
				}
			}
			
			queen(num+1, board);
		}		
	}
}
