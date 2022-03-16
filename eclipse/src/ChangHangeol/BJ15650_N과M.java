package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_N과M {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		functionname(new StringBuilder(), 0, 1);
		System.out.println(sb);
	}
	public static void functionname(StringBuilder ssbref, int count, int num) {
		if(num > n+1) return;
		if(count == m) {
			sb.append(ssbref + "\n");
			return;
		}
		StringBuilder ssb = new StringBuilder();
		ssb.append(ssbref);
		ssb.append(num + " ");
		functionname(ssb   , count+1, num+1);
		functionname(ssbref, count  , num+1);
	}
}
