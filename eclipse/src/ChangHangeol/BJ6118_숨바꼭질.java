package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 제일 먼 노드가 어디인가.
public class BJ6118_숨바꼭질 {
	static class node implements Comparable<node>{
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N+1];
		ArrayList<Integer>[] grp = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
				grp[i] = new ArrayList<>();
		// 세팅 끝.
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			grp[a].add(b);
			grp[b].add(a);
		}
		// 입력 완료.
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		int visited = 0;
		int maxdist = 0;
		pq.add(new node(1, 1));
		while(visited < N) {
			node now = pq.poll();
			
			if(dist[now.v] != 0 ) continue;
			dist[now.v]= now.w;
			visited++;
			maxdist = now.w;
			
			for(int n : grp[now.v]) {
				if(dist[n] != 0) continue;
				else 
					pq.add(new node(n, now.w + 1));
			}
		}
		
		// 최대 거리인 것들 중 제일 작은 위치, 그때 거리, 그 수.
		int count = 0;
		int nodenum = 0;
		for(int i = N; i > 0; i--) {
			if(dist[i] == maxdist) {
				count++;
				nodenum = i;
			}
		}
		System.out.println(nodenum + " " + (maxdist-1) + " " + count);
	}
}
