package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj9252_LCS2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int[][] lcs = new int[str1.length + 1][str2.length + 1];
		int max = 0;
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					max = Math.max(lcs[i][j], max);
				} else
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
			}
		}
		List<Character> ans = new ArrayList<Character>();
		int i = str1.length;
		int j = str2.length;
		for(;;) {
			int val = lcs[i][j];
			if(val == 0)
				break;
			if(lcs[i][j-1] == val)
				j--;
			else if(lcs[i-1][j] == val)
				i--;
			else {
				i--;
				j--;
				ans.add(str1[i]);
			}
		}
		sb.append(max).append("\n");
		for(int t = ans.size()-1; t>=0; t--)
			sb.append(ans.get(t));
		System.out.println(sb.toString());
	}
}
