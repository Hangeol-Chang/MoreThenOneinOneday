import java.util.Scanner;

public class BJ2563_색종이 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int T = in.nextInt();
		int[][] board = new int[100][100];
		
		for(int t = 1; t <= T; t++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			for(int i = y; i < y+10; i++) {
				for(int j = x; j < x+10; j++) {
					board[i][j] = 1;
				}
			}
		}
		int fill = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(board[i][j] == 1) fill++;
			}
		}
		System.out.println(fill);
		in.close();
	}
}
