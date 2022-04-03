package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//메모리 초과

public class BJ9663_N_Queen {
	static int N, count;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	static class node {
		int r, c;
		node(int r, int c){ this.r = r; this.c = c; }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		boolean[][] board = new boolean[N][N];
		queen(0, board);
		
		System.out.println(count);
	}
	private static void queen(int num, boolean[][] board) {
		if(num == N) {
			count++;
			return;
		}
		
		for(int j = 0; j < N; j++) {
			if(board[num][j] == true) continue;
			
			Queue<node> que = new LinkedList<>();
			// 퀸 놓기
			board[num][j] = true;
			que.add(new node(num, j));
			
			// 퀸이 움직일 수 있는 범위 전부 칠하기.
			for(int d = 0; d < 8; d++) {
				int nr = num + dr[d];
				int nc = j   + dc[d];
				
				while(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if(board[nr][nc] == false) {
						board[nr][nc] = true;
						que.add(new node(nr, nc));
					}
					nr += dr[d];
					nc += dc[d];
				}
			}
			
			queen(num+1, board);
			
			// 칠했던 거 되돌려놓기
			while(!que.isEmpty()) {
				node nd = que.poll();
				board[nd.r][nd.c] = false;
			}
		}		
	}
}
