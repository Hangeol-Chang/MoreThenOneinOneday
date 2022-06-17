

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[][] check = new int[a.length()+1][b.length()+1];
		
		//자기 윗줄에서, 0이 아닌 것을 가져와 1 더하고, 뒤에 것을 전부 그걸로 바꿈.
		int maxnum = 0;
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if( a.charAt(i-1) == (b.charAt(j-1))) {
					check[i][j] = check[i-1][j-1] + 1;
					maxnum = Math.max(check[i][j], maxnum);
				}
				else {
					check[i][j] = Math.max(check[i][j-1], check[i-1][j]);
				}
			}
		}
//		for(int i = 0; i <= a.length(); i++) {
//			for(int j = 0; j <= b.length(); j++) {
//				System.out.print(check[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(maxnum);
	}
}

/*

ABCDEFGAAABCDEFG
AVVVVVAAAABCD
*/