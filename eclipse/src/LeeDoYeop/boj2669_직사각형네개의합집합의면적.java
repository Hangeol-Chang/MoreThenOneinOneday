package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2669_직사각형네개의합집합의면적 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] square = new int[101][101];
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					square[r][c] = 1;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				sum += square[i][j];
			}
		}
		System.out.println(sum);
	}
}
