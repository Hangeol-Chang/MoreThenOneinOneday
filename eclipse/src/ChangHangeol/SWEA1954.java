package ChangHangeol;
import java.util.Scanner;

public class SWEA1954 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		
		
		int[] dc = {0,1,0,-1};
		int[] dr = {1,0,-1,0};
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			int n = in.nextInt();
			int pown = (int)Math.pow(n, 2);
			int[][] board = new int[n][n];
			
			//모드는 1씩 더하고 4로 나누는걸로 계속
			int mod = 0;
			
			int col = 0;
			int row = 0;
			int i = 1;
			while(i <= pown) {
				//보드에 넣고 i에 1 더해놓기
				board[col][row] = i++;
				
				//mod 올릴지 말지 결정
				if((col + dc[mod]) >= n || (row + dr[mod]) >= n || 
				   (col + dc[mod]) < 0 || (row + dr[mod]) < 0 || 
					board[col+dc[mod]][row+dr[mod]] !=0 )
					mod = (mod+1)%4;
			
				//보드 위치 선정
				col += dc[mod];
				row += dr[mod];
			}
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					sb.append(board[y][x] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		in.close();
	}
}
