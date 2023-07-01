

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11403_경로찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(map[i], 1000);
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				int a = Integer.parseInt(st.nextToken());
				if(a != 0) map[i][j] = a;
			}
		}
		// 입력 완료
		
		for(int k = 0; k < N; k++)
			for(int i = 0; i < N; i++) {
				if(k == i) continue;
				for(int j = 0; j < N; j++) {
					if(j == k) continue;
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		// 수정 완료
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] == 1000 ? "0 " :  "1 ");
			}
			System.out.println();
		}
	}
}
