package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class SWEA1251 {
	// 간선정보가 아닌 노드정보를 담음.
	static class node implements Comparable<node> {
		int x, y, idx;
		double w;
		node(int x, int y, double w, int idx){
			this.x = x;
			this.y = y;
			this.w = w;
			this.idx = idx;
		}
		// 가중치에 대해 pq를 정렬할 것.
		@Override
		public int compareTo(node o) {
			return Double.compare(this.w, o.w);
		}
	}
	static boolean[] visited;
	static int[][] map;
	static int N;
	static double E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[2][];
			for(int i = 0; i < 2; i++)
				map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			E = Double.parseDouble(br.readLine());
			// 입력 완료.
			
			visited = new boolean[N];
			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.add(new node(map[0][0], map[1][0], 0, 0));
			
			int count = 0;
			double ans = 0;
			while(count < N) {
				node nd = pq.poll();
				if(visited[nd.idx]) continue;
				visited[nd.idx]= true;
				ans += nd.w;
				count++;
				
				// 내가 갈 수 있는 모든 노드에 대해 가중치 테스트.
				for(int i = 0; i < N; i++) {
					if(visited[i]) continue;
					// 가중치 계산
					double w = (E*( Math.pow(nd.x - map[0][i], 2) + Math.pow(nd.y - map[1][i], 2) ));
					pq.add(new node(map[0][i], map[1][i], w, i));
				}
			}
			long ans2 = (long) (ans + 0.5);
			sb.append("#" + t + " " + ans2 + "\n");
		}
		System.out.println(sb);
	}
}

/*

1
2
0 0
0 100
1.0

1
50
6 1 0 3 4 8 5 6 6 0 6 7 2 7 3 5 8 6 6 4 9 5 2 8 7 5 9 1 9 1 6 7 0 9 2 5 1 7 1 3 1 2 0 5 7 4 0 4 2 0 
4 8 1 1 3 0 5 7 3 9 0 2 7 4 8 9 6 9 6 4 0 7 4 9 3 0 7 1 4 3 5 1 7 5 2 1 7 8 4 4 5 8 8 4 6 2 2 1 9 0 
0.5675

1
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005

*/