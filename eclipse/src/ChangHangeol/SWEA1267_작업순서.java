package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267_작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#" + t);
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] grp = new ArrayList[V+1];
			int[] indegree = new int[V+1];
			for(int i = 1; i <= V; i++) grp[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int stt = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				grp[stt].add(end);
				indegree[end]++;
			}
			
			Queue<Integer> que = new LinkedList<>();
			for(int i = 1; i <= V; i++)
				if(indegree[i] == 0) que.add(i);
			
			while(!que.isEmpty()) {
				int now = que.poll();
				sb.append(" " + now);
				for(int child : grp[now]) {
					if( --indegree[child] == 0) {
						que.add(child);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
