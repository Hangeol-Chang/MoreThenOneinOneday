

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1991_트리순회 {
	static int[][] tree;
	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		tree = new int[n+1][2];
		StringTokenizer st;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int loc = (int)(st.nextToken().charAt(0))-64;
			for(int d = 0; d < 2; d++) {
				int a = (int)(st.nextToken().charAt(0));
				// 46은 .의 아스키값
				if(a != 46) {
					// A값을 1로 두고 계산
					tree[loc][d] = a-64;
				}
			}
		}
		firstsearch(1);
		sb.append("\n");
		middlesearch(1);
		sb.append("\n");
		lastsearch(1);
		
		System.out.println(sb);
	}
	
	public static void firstsearch(int idx) {
		sb.append( (char)(idx+64) );
		if(tree[idx][0] != 0) firstsearch(tree[idx][0]);
		if(tree[idx][1] != 0) firstsearch(tree[idx][1]);
	}
	public static void middlesearch(int idx) {
		if(tree[idx][0] != 0) middlesearch(tree[idx][0]);
		sb.append( (char)(idx+64) );
		if(tree[idx][1] != 0) middlesearch(tree[idx][1]);
	}
	public static void lastsearch(int idx) {
		if(tree[idx][0] != 0) lastsearch(tree[idx][0]);
		if(tree[idx][1] != 0) lastsearch(tree[idx][1]);
		sb.append( (char)(idx+64) );
	}
}

/*
ABDCEFG
DBAECFG
DBEGFCA

ABDCEFG
DBAECFG
DBEGFCA
*/