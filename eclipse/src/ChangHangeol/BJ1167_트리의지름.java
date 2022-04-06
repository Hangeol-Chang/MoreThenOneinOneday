package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1167_트리의지름 {
	static class node {
		int v, w;
		node(int v, int w){
			this.v = v; this.w = w;
		}
	}
	static ArrayList<node>[] tree;
	static boolean[] vi;
	static int V;
	static node maxdist = new node(0,0);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		vi = new boolean[V+1];
		tree = new ArrayList[V+1];
		for(int i = 0; i <= V; i++) tree[i] = new ArrayList<>();
		
		for(int t = 1; t <= V; t++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			
			// 가능한 한 넣어주기.
			int v = Integer.parseInt(st.nextToken());
			while(v != -1) {
				int w = Integer.parseInt(st.nextToken());
				
				tree[u].add(new node(v, w));
				tree[v].add(new node(u, w));
				v = Integer.parseInt(st.nextToken());
			}
		}
		
		// 제일 먼 노드 찾기
		vi[1] = true;
		findpath(1, 0);

		// 지름 구하기.
		vi = new boolean[V+1];
		vi[maxdist.v]= true;
		findpath(maxdist.v, 0);
		
		System.out.println(maxdist.w);
	}
	public static void findpath(int idx, int len) {
		boolean cango = false;
		for(node nd : tree[idx]) {
			if(vi[nd.v]) continue;
			vi[nd.v] = true;
			
			findpath(nd.v, len + nd.w);
			cango = true;
		}
		if(!cango) {
			if(maxdist.w <= len) {
				maxdist.v = idx;
				maxdist.w = len;
			}
			return;
		}
	}
}
