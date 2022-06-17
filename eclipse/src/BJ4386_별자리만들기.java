

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4386_별자리만들기 {
	static int[] p;
	static class vertex implements Comparable<vertex> {
		int u, v;
		double w;
		vertex(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(vertex o) {
			return Double.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double[][] map = new double[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Double.parseDouble(st.nextToken());
			map[i][1] = Double.parseDouble(st.nextToken());
		}
		// 입력 완료
		
		PriorityQueue<vertex> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				double dist = Math.sqrt(Math.pow(map[i][0] - map[j][0], 2) + Math.pow(map[i][1] - map[j][1], 2));
				pq.add(new vertex(i, j, dist));
			}
		}
		// 자료 정리 완료
		
		p = new int[N];
		for(int i = 0; i < N; i++) p[i] = i;
		
		int selected = 0;
		double cost = 0;
		while(selected < N-1) {
			vertex now = pq.poll();
			
			if(parent(now.u) == parent(now.v)) continue;
			
			selected++;
			cost += now.w;
			union(now.u, now.v);
		}
		System.out.printf("%.2f", cost);
	}
	public static int parent(int x) {
		if(p[x] == x) return x;
		else return p[x] = parent(p[x]);
	}
	public static void union(int x, int y) {
		p[parent(y)] = parent(x);
	}
}
