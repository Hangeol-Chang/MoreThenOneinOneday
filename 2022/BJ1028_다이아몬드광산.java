

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ1028_다이아몬드광산 {
	static int R;
	static int C;
	static int size = 0;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][];
		for(int i = 0; i < R; i++) {
			board[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		//입력받기 끝.
		
		//count가 커지면, R-count까지만 뒤져도 됨.
		//C도 마찬가지.
		for(int r = 0; r < R-(size*2); r++) {
			for(int c = 0; c < C-size; c++) {
				if(board[r][c] == 1) spread(r, c, c, 1);
			}
		}
		System.out.println(size);
	}
	
	//하나 늘리고, 닫는 코드와 더 늘리는 코드 작성.
	public static void spread(int r, int c1, int c2, int nowsize) {
		if(nowsize > size) close(r, c1, c2, nowsize);
		
		c1--;
		c2++;
		r++;
		if(c1 >= 0  && c2 < C && r < R) {
			if(board[r][c1] == 1 && board[r][c2] == 1) {
				spread(r, c1, c2, ++nowsize);
			}
		}
		return;
		
	}
	public static void close(int r, int c1, int c2, int nowsize) {
		if(c1 < 0 || c2 >= C || r >= R) return;
		else if(board[r][c1]==1 && board[r][c2]==1) {
			if(c1 == c2) {
				size = Math.max(size, nowsize);
			}
			else {
				close(++r, ++c1, --c2, nowsize);
			}
		}
	}
}
