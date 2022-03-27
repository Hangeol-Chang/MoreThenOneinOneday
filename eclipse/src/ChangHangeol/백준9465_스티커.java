package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준9465_스티커 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sti = new int[3][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					sti[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력받기 끝.
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < 3; j++) {
					sti[j][i] += Math.max(sti[(j+1)%3][i-1], sti[(j+2)%3][i-1]);		
				}
			}
			// sum 구하기 끝.
			int max = Math.max(sti[0][n-1],  Math.max(sti[1][n-1], sti[2][n-1]));
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}
