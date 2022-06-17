

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 언젠가 풀자.
public class BJ2098_외판원순회 {
	static class node implements Comparable<node> {
		int v, w, c;
		node(int v, int w, int c){
			this.v = v;
			this.w = w;
			this.c = c;
		}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 그래프 배열 정의
		ArrayList<node>[] grp = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();
		
		// 입력받기
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				
				// 그래프에 등록
				grp[i].add(new node(j, w, 0));
			}
		}
		// 입력 완료
		
		boolean[] visited = new boolean[N+1];
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1, 0, 1));
		while(!pq.isEmpty()) {
			node now = pq.poll();
			
			if(now.v == 1 && now.w != 0 && now.c == N) {
				System.out.println(now.w);
				return;
			}
			
			System.out.println(now.v + " " + now.w + " " + now.c);
			
			for(node nd : grp[now.v]) {
				System.out.println(now.v + " " + nd.v);
				pq.add(new node(nd.v, now.w + nd.w, now.c + 1));
			}
			System.out.println(pq);
		}
	}
}
