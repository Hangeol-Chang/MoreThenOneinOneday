

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1865_동철이의일분배 {
	static int[][] map;
	static boolean[] clear;
	static double maxper;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][];
			clear = new boolean[N];
			maxper = 0;
			
			for(int i = 0; i < N; i++)
				map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 입력받기 끝.
			
			select(0, 100);
			sb.append("#" + t + " " + String.format("%8.6f",maxper) + "\n");
		}
		System.out.println(sb);
	}
	public static void select(int sel, double per) {
		// 백트래킹
		if(Double.compare(maxper, per) >= 0) return;
		if(sel == N) {
			maxper = Math.max(maxper, per);
			return;
		}
		// 순열
		for(int i = 0; i < N; i++) {
			if(clear[i]) continue;
			clear[i] = true;
			
			select(sel+1, (per * (map[sel][i] / 100.0)));
			
			clear[i] = false;
		}
	}
}
