package ChangHangeol;

import java.util.Scanner;

public class BJ15649_N과M1 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] vi;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		vi = new boolean[N+1];
		
		add("", 0);
		System.out.println(sb);
	}
	public static void add(String ssb, int count) {
		if(count == M) {
			sb.append(ssb + "\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(vi[i]) continue;
			vi[i] = true;
			
			add(ssb + i + " ", count+1);
			vi[i] = false;
		}
	}
}
