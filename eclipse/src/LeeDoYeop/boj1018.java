package LeeDoYeop;
import java.util.Scanner;

public class boj1018 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 
		int M = sc.nextInt(); 

		int[][] c = new int[N][M]; 
		char[][] chess = new char[N][M];

		for (int i = 0; i < N; i++) {
			chess[i] = sc.next().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {

				int cnt1 = 0;
				int cnt2 = 0;

				for (int x = i, m = 0; x < 8 + i; x++, m++) {
					for (int y = j, n = 0; y < 8 + j; y++, n++) {
						char cp = ((x + y) % 2 == 0) ? 'W' : 'B';
						if (chess[x][y] != cp)
							cnt1++;
						else
							cnt2++;
					}
				}

				if (cnt1 > cnt2)
					result = cnt2;
				else
					result = cnt1;

				if (min > result)
					min = result;
			}
		}
		System.out.println(min);
	}

}