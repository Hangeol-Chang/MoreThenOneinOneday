package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ15663_N과M12 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[][] nodes;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			set.add(v);
		}
		arr.addAll(set);
		// 입력 받기 끝.
		
		powerset(0, 0, new StringBuilder());
		
		System.out.println(sb);
	}
	public static void powerset(int count, int idx, StringBuilder merge) {
		if(count == M) {
			sb.append(merge + "\n");
			return;
		}
		// 해쉬맵 새로 복사
		StringBuilder newmerge = new StringBuilder();
//		System.out.println(count + " " + map);
		for(int i = idx; i < arr.size(); i++) {
			int val = arr.get(i);
			newmerge.setLength(0);
			newmerge.append(merge).append(val + " ");
			powerset(count+1, i, newmerge);
		}
	}
}
