package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932_정수삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n+1][n+1];
		
		StringTokenizer st;
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				triangle[i][j] = tmp + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		
		int max = 0;
		for(int j = 1; j < n+1; j++) {
			max = Math.max(max,  triangle[n][j]);
		}
		System.out.println(max);
	}
}
