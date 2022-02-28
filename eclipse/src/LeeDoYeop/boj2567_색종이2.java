package LeeDoYeop;
import java.util.Scanner;

public class boj2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = 0;
		int b = 0;
		int cnt = 0;
		int[][] arr = new int[105][105];
		for (int t = 0; t < N; t++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			if (c == 0)
				a = 1;
			if (r == 0)
				b = 1;
			for (int k = r + b; k < r + b + 10; k++) {
				for (int l = c + a; l < c + a + 10; l++)
					arr[k][l] = 1;
			}
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		for (int i = 1; i < 104; i++) {
			for (int j = 1; j < 104; j++) {
				if (arr[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (arr[nr][nc] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
