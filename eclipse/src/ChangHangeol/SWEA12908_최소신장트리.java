package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA12908_최소신장트리 {
	static class line implements Comparable<line> {
		int u, v, w;
		line(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(line o) {
			return this.w - o.w;
		}
	}
	static int[] p;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			PriorityQueue<line> pq = new PriorityQueue<>();
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				// 큐에 가중치 순으로 넣기.
				pq.add(new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			// 입력 완료
			
			// 부모 초기화
			p = new int[N+1];
			for(int i = 1; i <= N; i++) p[i] = i;
			
			int count = 0;
			int ans = 0;
			// 정점-1 개가 될 때 까지 선택 진행.
			while(count < N) {
				line now = pq.poll();
				// 부모가 다르면 선택.
				if(!same(now)) {
					Union(now);
					ans += now.w;
					count++;
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	static int find(int x) {
		if(x == p[x]) return x;
		else 		  return p[x] = find(p[x]);
	}
	static void Union(line l) {
		p[find(l.v)] = find(l.u);
	}
	static boolean same(line l) {
		return (find(l.u) == find(l.v)); 
	}
}
