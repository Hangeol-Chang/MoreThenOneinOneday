package Making;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class M220423_test1 {
	static int N, K, B;
	static int[] map;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	static boolean clear;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			map = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			sel = new int[K];
			
			sb.append("#" + t);
			clear = false;
			
			search(0, 0, 0, 0);
			
			if(!clear) sb.append(" -1\n");
		}
		System.out.println(sb);
	}
	public static void search(int selidx, int idx, int count, int sum) {
		// 백트래킹
		if(sum > B || clear) return;
		
		if(sum == B) {
			clear = true;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i < selidx; i++)
				if(sel[i] != 0) pq.add(sel[i]);
			
			while(!pq.isEmpty()) sb.append(" " + pq.poll());
			sb.append("\n");
		}
		if(idx == N || selidx == K) return;
		
		// 나를 포함하지 않고 넘기기.
		search(selidx, idx+1, count, sum);
		// 나를 포함해서 넘기기.
		sel[selidx] = map[idx];
		search(selidx+1, idx+1, count+1, sum + map[idx]);
	}
}