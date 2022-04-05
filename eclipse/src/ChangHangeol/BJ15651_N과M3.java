package ChangHangeol;

import java.util.Scanner;

public class BJ15651_N과M3 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		add("", 0);
		System.out.println(sb);
	}
	public static void add(String ssb, int count) {
		if(count == M) {
			sb.append(ssb + "\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			add(ssb + i + " ", count+1);
		}
	}
}
