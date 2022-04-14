package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_요리사 {
	static int N;
	static int min;
	static int[][] ingre;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ingre = new int[N+1][N+1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++)
					ingre[i][j] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝.
			
			for(int i = 1; i <= N; i++) {
				for(int j = i+1; j <= N; j++) {
					ingre[i][j] += ingre[j][i];
				}
			}
			// 정리 끝.
			min = 40000;
			select(0, 0, 0);
			
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}
	
	public static void select(int bit, int count, int idx) {
		if(idx > N) return;
		if(count == N/2) {
//			System.out.println(bit);
			calc(bit);
			return;
		}
		// 이번 재료를 넣고 넘기느냐, 안넣고 넘기느냐.
		select(bit | 1<<idx , count+1, idx+1);
		select(bit, count, idx+1);
	}
	public static void calc(int bit) {
		int mat1 = 0;
		int mat2 = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = i+1; j <= N; j++) {
				if ((bit & 1<<i) > 0 ){
					if((bit & 1<<j) > 0) mat1 += ingre[i][j];
				}
				else if( (bit & 1<<j) == 0) mat2 += ingre[i][j];
			}
		}
//		System.out.println(bit1 + " : " + mat1 + " || " + bit2 + " : " + mat2);
		min = Math.min(Math.abs(mat1-mat2), min);
	}
}

/*

1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0

*/