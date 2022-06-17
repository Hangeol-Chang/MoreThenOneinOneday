

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 한 섬에서 시작해서, 이 섬에서 갈 수 있는 모든 위치로 다리를 놓아 보고,
 길이가 최소인 다리를 선택. 그 다리가 연결된 땅으로 이동하여 반복.
 다리를 못 놓은 상황이 확정되면, -1 출력하고 끝내기.
 */
public class BJ17472_다리만들기2_2 {
	static class loc{
		int r, c;
		loc(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static class line implements Comparable<line>{
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
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] visited;
	static int[] p;
	static int islandc = 1;
	static int maxlen = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];		
		for(int i = 0; i <= N+1; i++) Arrays.fill(map[i], 2);
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++)
				map[i][j]= Integer.parseInt(st.nextToken());
		}
		// 입력 끝.
		ArrayList<loc>[] islands = new ArrayList[7];
		for(int i = 1; i <= 6; i++) islands[i] = new ArrayList<>();
		
		// 섬의 갯수 세기
		visited = new boolean[N+2][M+2];
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(!visited[r][c] && map[r][c] == 1) {
					Queue<int[]> que = new LinkedList<>();
					que.add(new int[] {r, c});
					
					while(!que.isEmpty()) {
						int[] now = que.poll();
						if(visited[now[0]][now[1]]) continue;
						visited[now[0]][now[1]] = true;
						islands[islandc].add(new loc(now[0], now[1]));
						
						for(int d = 0; d < 4; d++) {
							int nr = now[0] + dr[d];
							int nc = now[1] + dc[d];
							if(map[nr][nc] == 2) continue;
							
							if(map[nr][nc] == 1 && !visited[nr][nc]) {
								que.add(new int[] {nr, nc});
							}
						}
					}
					islandc++;
				}
			}
		}
//		// 세팅 끝.
//		for(int i = 1; i < islandc; i++) {
//			System.out.println(i);
//			for(loc nd : islands[i]) {
//				System.out.println("위치들 : " + nd.r + " " + nd.c);
//			}
//			System.out.println();
//		}
		
		// 모든 섬에서 섬으로 가는 길 찾기.
		PriorityQueue<line> lines = new PriorityQueue<>();
		
		for(int i = 1; i < islandc; i++) {
			for(int j = i+1; j < islandc; j++) {
			// 섬의 모든 좌표에 대해 테스트.
				int min = Integer.MAX_VALUE;
				for(loc l1 : islands[i]) {
					inner : for(loc l2 : islands[j]) {
						if(l2.r == l1.r && Math.abs(l2.c - l1.c) > 2 && Math.abs(l2.c - l1.c) < min) {
							int sst = Math.min(l2.c, l1.c);
							int eed = Math.max(l2.c, l1.c);
							for(int p = sst+1; p < eed; p++) {
								if(map[l2.r][p] == 1) continue inner;
							}
							min = Math.min(min, Math.abs(l2.c - l1.c));
						} else if(l2.c == l1.c && Math.abs(l2.r - l1.r) > 2 && Math.abs(l2.r - l1.r) < min) {
							int sst = Math.min(l2.r, l1.r);
							int eed = Math.max(l2.r, l1.r);
							for(int p = sst+1; p < eed; p++) {
								if(map[p][l2.c] == 1) continue inner;
							}
							min = Math.min(min,  Math.abs(l2.r - l1.r));
						}
					}
				}
				// 구해진 최솟값이 나오는 위치.
				// 무향 그래프로, 양쪽 다 입력해 줘야 함.
				if(min != Integer.MAX_VALUE) {
					lines.add(new line(i, j, min-1));					
					lines.add(new line(j, j, min-1));
				}
			}
		}
		// 간선 다 구함 드디어 ㅅㅂ
		
		// 크루스칼
		p = new int[islandc];
		for(int i = 1; i < islandc; i++) p[i] = i;
		int select = 0;
		int ans = 0;
		while(select < islandc-2 && !lines.isEmpty()) {
			line now = lines.poll();
			if(!same(now.u, now.v)) {
				ans += now.w;
				union(now.u, now.v);
				select++;
			}
		}
		System.out.println(select == islandc-2 ? ans : -1 );
	}
	public static int findset(int x) {
		if (p[x] == x) return x;
		else 		   return p[x] = findset(p[x]);
	}
	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
	public static boolean same(int x, int y) {
		return (findset(x) == findset(y));
	}
}


/*

7 8
0 0 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
1 1 0 0 0 1 1 0
0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1


*/