package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504_특정한최단경로 {
	public static class node implements Comparable<node> {
		int v, w;
		node(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	static ArrayList<node>[] grp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		grp = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grp[u].add(new node(v, w));
			grp[v].add(new node(u, w));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// 입결받기 끝.

		int[] fromv1 = new int[N+1]; Arrays.fill(fromv1, 8000000);
		int[] fromv2 = new int[N+1]; Arrays.fill(fromv2, 8000000);
		dijkstra(fromv1, v1);
		dijkstra(fromv2, v2);
		
		int set1 = fromv1[1] + fromv2[N];
		int set2 = fromv1[N] + fromv2[1];
		int ans = Math.min(set1, set2) + fromv1[v2];
		System.out.println(ans < 8000000 ? ans : -1 );
	}
	public static void dijkstra(int[] from, int v) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(v, 0));
		
		while(!pq.isEmpty()) {
			node a = pq.poll();
			// 방문한 적이 있으면 지나가기.
			if(from[a.v] < 8000000) continue;
			// 방문처리
			from[a.v] = a.w; 
			
			for(node nd : grp[a.v]) {
				if(from[nd.v] < 8000000) continue;
				pq.add(new node(nd.v, nd.w + a.w));
			}
		}
	}
}



































