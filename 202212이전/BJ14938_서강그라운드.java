import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 크루스칼
public class BJ14938_서강그라운드 {
	static class vertex implements Comparable<vertex> {
		int v, w;
		vertex(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(vertex o) {return this.w - o.w;}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지역의 수
		int n = Integer.parseInt(st.nextToken());
		// 수색 범위
		int m = Integer.parseInt(st.nextToken());
		// 길의 수
		int r = Integer.parseInt(st.nextToken());
		
		int[] items = new int[n+1];
		st = new StringTokenizer(br.readLine());
		ArrayList<vertex>[] map = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new vertex(v, w));
			map[v].add(new vertex(u, w));
		}
		// 시작지점을 내가 정해야되...네?
		
		// n개의 시작점에 대해 테스트
		int maxeat = 0;
		for(int i = 1; i <= n; i++) {
			int[] dist = new int[n+1];
			// 자기 자신 먹은걸로 처리(수색범위는 항상 1보다 크거나 같음.)
			dist[i] = 1;
			
			// 크루스칼
			PriorityQueue<vertex> pq = new PriorityQueue<>();
			for(vertex v : map[i]) pq.add(v);
			while(!pq.isEmpty()) {
				vertex now = pq.poll();
				
				if(now.w > m) break;
				dist[now.v] = now.w;
				
				for(vertex v : map[now.v])
					if (dist[v.v] == 0)
						pq.add(new vertex(v.v, v.w + now.w));
			}
			
			int tmpeat = 0;
			for(int j = 1; j <= n; j++) {
//				System.out.print(dist[j] + " ");
				if(dist[j] > 0) tmpeat += items[j];
			}
//			System.out.println();
			maxeat = Math.max(tmpeat, maxeat);
		}
		System.out.print(maxeat);
	}
}
