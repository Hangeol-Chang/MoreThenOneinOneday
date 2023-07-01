

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1647_도시분할계획 {
	public static class vertex implements Comparable<vertex>{
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<vertex> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new vertex(u, v, w));
		}
		p = new int[N+1];
		for(int i = 0; i <= N; i++) p[i] = i;
		
		int selcount = 0;
		long cost = 0;
		while(selcount < N-2) {
			vertex now = pq.poll();
			
			if(parent(now.u) == parent(now.v)) continue;
			
			union(now.u, now.v);
			cost += now.w;
			selcount++;
		}
		System.out.print(cost);
	}
	public static void union(int x, int y) {
		p[parent(y)] = parent(x);
	}
	public static int parent(int x) {
		if(p[x] == x) return x;
		else return p[x] = parent(p[x]);
	}
}
