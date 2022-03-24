package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ15663_N과M9 {
	static StringBuilder sb = new StringBuilder();
	static int[][] nodes;
	static int M;
//해쉬맵
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			int val = 1;
			if(map.containsKey(key)) { val += map.get(key); }
			map.put(key, val);
		}
		// 입력 받기 끝.
		
		powerset(0, map, new StringBuilder());
		
		System.out.println(sb);
	}
	public static void powerset(int count, TreeMap<Integer, Integer> map, StringBuilder merge) {
		if(count == M) {
			sb.append(merge + "\n");
			return;
		}
		// 해쉬맵 새로 복사
		StringBuilder newmerge = new StringBuilder();
//		System.out.println(count + " " + map);
		for(int key : map.keySet()) {
			newmerge.setLength(0);
			int c = map.get(key); 
			newmerge.append(merge).append(key + " ");
			
			TreeMap<Integer, Integer> newmap = new TreeMap<>();
			newmap.putAll(map);
			if(c > 1) {
				int val = newmap.get(key) - 1;
				newmap.put(key, val);
			}
			else newmap.remove(key);
			powerset(count+1, newmap, newmerge);
		}
	}
}
