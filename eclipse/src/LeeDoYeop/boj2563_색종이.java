package LeeDoYeop;
import java.util.Scanner;

public class boj2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 도화지 100*100
		int[][] paper = new int[100][100];
		// 몇번 칠할지 정하기
		int N = sc.nextInt();
		// N번만큼 칠하기
		int count = 0;
		for (int i = 0; i < N; i++) {
			// 행 시작
			int r = sc.nextInt();
			int c = sc.nextInt();
			for (int row = r; row <= r + 9; row++) {
				for (int col = c; col <= c + 9; col++) {
					if (paper[row][col] == 0) {
						count++;
						paper[row][col] = 1;
					}
				}
			}
		}
		System.out.println(count);
	}
}
