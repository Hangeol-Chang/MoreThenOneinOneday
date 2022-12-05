

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ2342_DDR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][][] dp = new int[2][5][5];
		int ini = Integer.parseInt(st.nextToken());
		if(ini == 0) {
			System.out.println(0); return;
		}
		dp[0][ini][0] = 2;
		dp[0][0][ini] = 2;
		
		while(true) {
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) break;
			
//			System.out.println(a);
			for(int l = 0; l < 5; l++) {
				for(int r = 0; r < 5; r++) {
					if(dp[0][l][r] == 0) continue;
					
					// 왼발로 밟아보기
					if(a != r) {
						if(dp[1][a][r] == 0) dp[1][a][r] = getcost(l, a) + dp[0][l][r];
						else				 dp[1][a][r] = Math.min(getcost(l, a) + dp[0][l][r], dp[1][a][r]);
					}
					
					// 오른발로 밟아보기
					if(a != l) {
						if(dp[1][l][a] == 0) dp[1][l][a] = getcost(r, a) + dp[0][l][r];
						else				 dp[1][l][a] = Math.min(getcost(r, a) + dp[0][l][r], dp[1][l][a]);						
					}
				}
			}
			// dp 끝.
			// 슬라이딩 윈도 정리
			for(int i = 0; i < 5; i++) {
				dp[0][i] = dp[1][i].clone();				
//				System.out.println(Arrays.toString(dp[0][i]));
			}
			dp[1] = new int[5][5];
//			System.out.println("=======");
		}
		int min = 1000000;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(dp[0][i][j] == 0) continue;
				
				min = Math.min(min, dp[0][i][j]);
			}
		}
		System.out.print(min);
	}
	// foot : 0이 왼발, 1이 오른발
	static int getcost(int foot, int press) {
		int cost = 0;
		
		if(foot == 0) cost = 2;
		else if ( foot == press ) cost = 1;
		else if ( Math.abs(foot - press) == 2) cost = 4;
		else cost = 3;
		
		return cost;
	}
}
