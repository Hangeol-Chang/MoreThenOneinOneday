

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15657_N과M8 {
	static int N, M;
	static int[] nums;
	static int limit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0; i < N; i++) { que.add(Integer.parseInt(st.nextToken())); }
		nums = new int[N];
		// 정렬한 후 배열에 넣음.
		for(int i = 0; i < N; i++) { nums[i] = que.poll(); }
		
		// 비트마스크로 돌았는지 확인.
		for(int i = 0; i < N; i++) {
			dlfmaanjffhgkwl(i, 0, new StringBuilder());
		}
		System.out.println(sb);
	}
	public static void dlfmaanjffhgkwl(int idx, int count, StringBuilder s) {
		StringBuilder ss = new StringBuilder().append(s);
		ss.append(nums[idx] + " ");
		count++;
		
		if(count == M) {
			sb.append(ss + "\n");
			return;
		}
		
		for(int i = idx; i < N; i++) {			
				dlfmaanjffhgkwl(i, count, ss);
			
		}
	}
}

/*

6 3
1 5 3 4 6 8

*/