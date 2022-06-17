

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197_최소스패닝트리 {
	public static class vertex implements Comparable<vertex> {
		int u, v, w;
		vertex(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(vertex o) {
			return this.w - o.w;
		}
		
	}
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<vertex> pq = new PriorityQueue<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			pq.add(new vertex(u, v, w));
		}
		p = new int[V+1];
		for(int i = 0; i <= V; i++) p[i] = i;
		
		int selcount = 0;
		int totalw = 0;
		while(selcount < V-1) {
			vertex now = pq.poll();
			
			// 같은 집합이면 넘어가기
			if(parent(now.u) == parent(now.v)) continue;
			
			// 합치기
			union(now.u, now.v);
			selcount++;
			totalw += now.w;
		}
		System.out.println(totalw);
	}
	public static void union(int x, int y) {
		p[parent(y)] = parent(x); 
	}
	public static int parent(int x) {
		if( p[x] == x) {
			return x;
		}else {
			return p[x] = parent(p[x]);
		}
	}
}