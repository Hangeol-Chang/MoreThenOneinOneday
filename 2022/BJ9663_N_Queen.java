

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//메모리 초과

public class BJ9663_N_Queen {
	static int N, count;
	static byte[] dr = {-1,1,0,0,-1,-1,1,1};
	static byte[] dc = {0,0,-1,1,-1,1,-1,1};
	static class node {
		byte r, c;
		node(byte r, byte c){ this.r = r; this.c = c; }
	}
	static Stack<node> stk = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Byte.parseByte(br.readLine());
		br.close();
		
		boolean[][] board = new boolean[N][N];
		queen((byte)0, board);
		
		System.out.println(count);
	}
	private static void queen(byte num, boolean[][] board) {
		if(num == N) {
			count++;
			return;
		}
		
		for(byte j = 0; j < N; j++) {
			if(board[num][j] == true) continue;
			// 퀸 놓기
			board[num][j] = true;
			stk.add(new node(num, j));
			short stkc = 1;
			
			// 퀸이 움직일 수 있는 범위 전부 칠하기.
			for(int d = 0; d < 8; d++) {
				byte nr = (byte) (num + dr[d]);
				byte nc = (byte) (j   + dc[d]);
				
				while(nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if(board[nr][nc] == false) {
						board[nr][nc] = true;
						stk.add(new node(nr, nc));
						stkc++;
					}
					nr += dr[d];
					nc += dc[d];
				}
			}
			
			queen((byte)(num+1), board);
			
			// 칠했던 거 되돌려놓기
			for(short ss = 0; ss < stkc; ss++)  {
				node nd = stk.pop();
				board[nd.r][nd.c] = false;
			}
		}	
		return;
	}
}
