package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
	static int N;
	static class node implements Comparable<node> {
		int v, w;
		node(int v, int w) {this.v = v; this.w = w;}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	static int[] dist;
	static boolean[] visited;
	static ArrayList<node>[] grp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 그래프 배열 만들기
		grp = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) grp[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist,  Integer.MAX_VALUE);
		visited = new boolean[N+1];
		
		StringTokenizer st;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			grp[u].add(new node(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 입력받기 끝.
		
		daikstra(start);
		
		System.out.println(dist[end]);
	}
	public static void daikstra(int start) {
		// 여기 들어가는 노드는, 
		// v에 현재 위치, w에 현재 길이를 저장함.
		PriorityQueue<node> que = new PriorityQueue<>();
		que.add(new node(start, 0));
		
		while(!que.isEmpty()) {
			node now  = que.poll();
			
			if(visited[now.v]) continue;
			visited[now.v] = true; 
			
			for(node target : grp[now.v]) {
				node next = new node(target.v, target.w + now.w);
				if(next.w < dist[next.v]) {
					dist[next.v]= next.w;
					que.add(next);
				}
			}
		}
	}
}
