package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_N과M4 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {			
			functionname(new StringBuilder(), 0, i);
		}
		System.out.println(sb);
	}
	public static void functionname(StringBuilder ssbref, int count, int num) {
		if(num > n) return;
		StringBuilder ssb = new StringBuilder();
		ssb.append(ssbref);
		ssb.append(num + " ");
		count++;
		if(count == m) {
			sb.append(ssb + "\n");
			return;
		}
		for(int j = num; j <= n; j++) {
			functionname(ssb, count, j);			
		}
	}
}

/*

1 1 1 
1 1 2 
1 1 3 
1 2 2 
1 2 3 
1 3 3 
2 2 2 
2 2 3 
2 3 3 
3 3 3 

1 1 1
1 1 2
1 1 3
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
*/