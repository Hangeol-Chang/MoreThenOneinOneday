package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9252_LCS2 {
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		
		int alen = a.length();
		int blen = b.length();
		int[][] map = new int[alen+1][blen+1];
		
		for(int aidx = 1; aidx <= alen; aidx++) {
			for(int bidx = 1; bidx <= blen; bidx++) {
				if (a.charAt(aidx-1) == b.charAt(bidx-1)) map[aidx][bidx] = map[aidx-1][bidx-1] + 1;
				else map[aidx][bidx] = Math.max(map[aidx-1][bidx], map[aidx][bidx-1]);
			}
		}
		// dp 끝
		System.out.println(map[alen][blen]);
		
		// 디버그
//		for(int i = 1; i <= alen; i++) {
//			for(int j = 1; j <= blen; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		StringBuilder ans = new StringBuilder();
		while(alen > 0 && blen > 0) {
			if(a.charAt(alen-1) == b.charAt(blen-1)) {
				ans.append(a.charAt(alen-1));
				alen--;
				blen--;
			}
			else {
				if(map[alen-1][blen] > map[alen][blen-1]) 
					 alen--;
				else blen--;
			}
		}
		if(!ans.equals("")) System.out.print(ans.reverse());
	}
}
