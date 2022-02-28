package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2578_빙고 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt2 = 0;
		outer: for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				cnt2++;
				check: for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (bingo[k][l] == num) {
							bingo[k][l] = 0;
							break check;
						}
					}
				}
				int cnt = 0;
				for (int c = 0; c < 5; c++) {
					if (c == 0) {
						if (bingo[c][0] == 0 && bingo[c][1] == 0 && bingo[c][2] == 0 && bingo[c][3] == 0
								&& bingo[c][4] == 0)
							cnt++;
						if (bingo[0][c] == 0 && bingo[1][c] == 0 && bingo[2][c] == 0 && bingo[3][c] == 0
								&& bingo[4][c] == 0)
							cnt++;
						if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0
								&& bingo[4][4] == 0)
							cnt++;
					} else if (c == 4) {
						if (bingo[c][0] == 0 && bingo[c][1] == 0 && bingo[c][2] == 0 && bingo[c][3] == 0
								&& bingo[c][4] == 0)
							cnt++;
						if (bingo[0][c] == 0 && bingo[1][c] == 0 && bingo[2][c] == 0 && bingo[3][c] == 0
								&& bingo[4][c] == 0)
							cnt++;
						if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0
								&& bingo[4][0] == 0)
							cnt++;
					} else {
						if (bingo[c][0] == 0 && bingo[c][1] == 0 && bingo[c][2] == 0 && bingo[c][3] == 0
								&& bingo[c][4] == 0)
							cnt++;
						if (bingo[0][c] == 0 && bingo[1][c] == 0 && bingo[2][c] == 0 && bingo[3][c] == 0
								&& bingo[4][c] == 0)
							cnt++;
					}
					if (cnt == 3) {
						System.out.println(cnt2);
						break outer;
					}
				}
			}
		}
	}
}
