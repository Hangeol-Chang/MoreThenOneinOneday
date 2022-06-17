

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4012_요리사2 {
	static int N;
	static int min;
	static int mat1, mat2;
	static int[] in1, in2;
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
			in1 = new int[N/2];
			in2 = new int[N/2];
			for(int i = 1; i <= N/2; i++) in1[i-1] = i;
			for(int i = N/2 + 1; i <= N; i++) in2[i-(N/2+1)] = i;
			// 입력 끝.
			
//			for(int i = 1; i <= N; i++) {
//				for(int j = i+1; j <= N; j++) {
//					ingre[i][j] += ingre[j][i];
//				}
//			}
			// 정리 끝.
			
			mat1 = 0;
			mat2 = 0;
			init();
			min = Math.abs(mat1 - mat2);
			
			for(int idf1 : in1)
				for(int idf2 : in2) {
					System.out.println(idf1 + " " + idf2);
					switchtest(idf1, idf2, mat1, mat2);
				}

			
			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}
	private static void switchtest(int idf1, int idf2, int mat1, int mat2) {
		// mat1에서 idf1꺼를 빼고, idf2꺼를 더함.
		// mat2는 반대로.
		for(int i : in1)
			if(idf1 != i) {
				mat1 -= ingre[i][idf1];
				mat1 -= ingre[idf1][i];
				mat1 += ingre[i][idf2];
				mat1 += ingre[idf2][i];
			}
		
		for(int i : in2)
			if(idf2 != i) {
				mat2 -= ingre[i][idf2];
				mat2 -= ingre[idf2][i];
				mat2 += ingre[i][idf1];
				mat2 += ingre[idf1][i];
			}
		
		min = Math.min(min, Math.abs(mat2-mat1));
	}
	public static void init() {
		for(int i = 1; i <= N/2 ; i++)
			for(int j = i+1; j <= N/2; j++) {
				mat1 += ingre[i][j];
				mat1 += ingre[j][i];				
			}
		
		for(int i = N/2 + 1; i <= N; i++) 
			for(int j = i+1; j <= N; j++){
				mat2 += ingre[i][j];
				mat2 += ingre[j][i];	
			}
	}
}

/*

1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0

1
10
0 229 257 895 817 917 144 864 51 242
795 0 519 281 868 100 653 995 722 756
190 106 0 547 996 469 195 734 928 629
897 72 601 0 905 823 551 590 934 727
612 255 431 453 0 126 303 926 731 96
913 385 951 218 399 0 510 726 343 457
174 790 862 336 367 311 0 646 436 806
578 842 294 863 436 614 602 0 951 462
655 791 752 672 228 444 611 833 0 64
517 115 573 42 250 879 58 79 372 0
*/