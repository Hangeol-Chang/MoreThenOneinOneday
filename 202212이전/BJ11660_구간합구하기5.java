

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		//1,1부터 여기까지를 다 더해오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] sums = new int[N+2][N+2];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				int rsum = sums[r-1][c];
				int csum = sums[r][c-1];
				int dup = sums[r-1][c-1];
				int num = Integer.parseInt(st.nextToken());
				
				sums[r][c] = num + rsum + csum - dup;
			}
		}
		// 입력받기 끝.
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= N; j++) {
//				System.out.print(sums[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int rsum = sums[x2][y1];
			int csum = sums[x1][y2];
			int dup = sums[x1][y1];
			int sum = sums[x2][y2] - rsum - csum + dup;
			sb.append( sum + "\n");
		}
		System.out.println(sb);
	}
}
