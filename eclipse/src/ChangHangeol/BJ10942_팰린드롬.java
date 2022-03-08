package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ10942_팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] check = new int[n][n];

		for(int i = 0; i < n; i++) {
			check[i][i] = 1;
			for(int j = i-1; j >= 0; j--) {
				if(nums[i] == nums[j]) {
					if(j+1 == i || check[j+1][i-1] == 1) check[j][i] = 1;
				}
				
//				for(int r= 0; r < n; r++) {
//					for(int c = 0; c < n; c++) {
//						System.out.print(check[r][c]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); 
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(check[i-1][j-1] + "\n");
		}
		System.out.println(sb);
	}
}


/*

13
1 2 3 2 1 1 1 1 3 7 2 1 1

*/