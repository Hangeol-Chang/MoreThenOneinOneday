package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1967_트리의지름 {
	static class node implements Comparable<node> {
		int v, w;
		node(int v, int w) {this.v = v; this.w = w;}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	static node maxd = new node(0, 0);
	static ArrayList<node>[] tree;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1에서 시작해서 왼쪽 끝, 오른쪽 끝 위치 재기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) tree[i] = new ArrayList<>();
		visited = new boolean[N+1];
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());		
			// u에서 v로 갈 때는 w의 가중치가 필요함.
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree[u].add(new node(v, w)); 
			tree[v].add(new node(u, w));
		}
		// 입력받기 끝.
		
		visited[1] = true;
		findpath(1, 0);
		
		visited = new boolean[N+1];
		visited[maxd.v] = true;
		findpath(maxd.v, 0);
		System.out.println(maxd.w);
	}
	
	// 가장 먼 정점 찾기.
	public static void findpath(int loc, int len) {
		boolean cango = false;
		for(node nd : tree[loc]) {
			if(visited[nd.v]) continue;
			visited[nd.v] = true;
			cango = true;
			
			findpath(nd.v, len + nd.w);
			visited[nd.v] = false; 
		}
		
		if(!cango) {
			if(maxd.w < len) {
				// 현재 위치를 저장.
				maxd.v = loc;
				maxd.w = len;
			}
			return;
		}
	}
}
