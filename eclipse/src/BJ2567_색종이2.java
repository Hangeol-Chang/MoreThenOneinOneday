
//1에서 0으로 바뀔 때, 0에서 1로 바뀔 때
import java.util.Scanner;

public class BJ2567_색종이2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int T = in.nextInt();
		int[][] board = new int[102][102];
		
		for(int t = 1; t <= T; t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			for(int i = y+1; i < y+11; i++) {
				for(int j = x+1; j < x+11; j++) {
					board[i][j] = 1;
				}
			}
		}
		int rounder = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(board[i][j] != board[i][j+1]) rounder++;
				if(board[i][j] != board[i+1][j]) rounder++;
			}
		}
		System.out.println(rounder);
		in.close();
	}
}
