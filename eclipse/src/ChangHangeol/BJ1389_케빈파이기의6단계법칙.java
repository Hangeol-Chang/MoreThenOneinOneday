package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1389_케빈파이기의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 유저 수 N, 관계 M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], 10);
			dist[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++) {
				if(i == k) continue;
				for(int j = 1; j <= N; j++) {
					if(j == i || j == k) continue;
					
					if(dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		int maxi = 1;
		int[] sums = new int[N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				sums[i] += dist[i][j];
			
			if(sums[maxi] > sums[i]) maxi = i;
		}
		System.out.println(maxi);
	}
}
