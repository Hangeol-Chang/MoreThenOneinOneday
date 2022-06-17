

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 한 섬에서 시작해서, 이 섬에서 갈 수 있는 모든 위치로 다리를 놓아 보고,
 길이가 최소인 다리를 선택. 그 다리가 연결된 땅으로 이동하여 반복.
 다리를 못 놓은 상황이 확정되면, -1 출력하고 끝내기.
 */
public class BJ17472_다리만들기2 {
	static class loc implements Comparable<loc>{
		int r, c;
		int len;
		int count;
		loc(int r, int c, int len, int count){
			this.r = r;
			this.c = c;
			this.len = len;
			this.count = count;
		}
		@Override
		public int compareTo(loc o) {
			return this.len - o.len;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map;
	static boolean[][] visited;
	static int islandc;
	static int maxlen = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+2][M+2];
		map = new int[N+2][M+2];		
		for(int i = 0; i <= N+1; i++) Arrays.fill(map[i], 2);
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++)
				map[i][j]= Integer.parseInt(st.nextToken());
		}
		// 입력 끝.
		
		// 섬의 갯수 세기
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(!visited[r][c] && map[r][c] == 1) {
					Queue<int[]> que = new LinkedList<>();
					que.add(new int[] {r, c});
					
					while(!que.isEmpty()) {
						int[] now = que.poll();
						if(visited[now[0]][now[1]]) continue;
						visited[now[0]][now[1]] = true;
						
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
		System.out.println("섬 수 : " + islandc);
		
		visited = new boolean[N+2][M+2];
		// 출발위치 하나 잡아서 시작.
		outer : for(int r = 1; r <= N; r++)
		for(int c = 1; c <= M; c++)
			if(map[r][c] == 1) {
				dfs(new loc(r, c, 0, 0));
				break outer;
			}
		
		// 계산 시작. dfs
		System.out.println(maxlen == Integer.MAX_VALUE ? -1 : maxlen);
		// 계산 시작. bfs 폐기
//		PriorityQueue<loc> pq = new PriorityQueue<>();
//		outer : for(int r = 1; r <= N; r++)
//			for(int c = 1; c <= M; c++)
//				if(map[r][c] == 1) {
//					pq.add(new loc(r, c, 0, 0));
//					break outer;
//				}
//		while(true) {
//			loc now = pq.poll();
//			if(now == null) { System.out.println(-1); return; }
//			else if(now.count >= islandc-1) { System.out.println(now.len); return; }
//			
//			System.out.println("현위치 : " + now.r + " " + now.c + ", 현재 길이 : " + now.len);
//			if(visited[now.r][now.c]) continue;
//			visited[now.r][now.c] = true;
//			
//			for(int d = 0; d < 4; d++) {
//				int nr = now.r + dr[d];
//				int nc = now.c + dc[d];
//				// 범위 컷.
//				if(map[nr][nc] == 2) continue;
//				
//				// 주변이 0일 떄와 1일 때로 나눠서, 
//				// 0일때는 가다가 1 만나는지 확인
//				// 1일때는 큐에 넣기
//				switch(map[nr][nc]) {
//				case 0 :
//					int len = 0;
//					while(map[nr][nc] == 0) {
//						nr += dr[d];
//						nc += dc[d];
//						len++;
//					}
//					if(len > 2 && map[nr][nc] == 1 && !visited[nr][nc]) {
//						pq.add(new loc(nr, nc, len + now.len, now.count+1));
//						System.out.println("큐에 넣음0 : " + nr + " " + nc + ", 길이 : " + (len + now.len));						
//					}
//					break;
//				case 1 :
//					if(!visited[nr][nc]) {
//						System.out.println("큐에 넣음1 : " + nr + " " + nc + ", 길이 : " + now.len);
//						pq.add(new loc(nr, nc, now.len, now.count));
//					}
//					break;
//				}
//			}
//			System.out.println();
//		}
	}
	public static void dfs(loc now) {
		// 백트래킹
		if(now.len > maxlen) return;
		// 다리를 다 만들었을 때. 비교해보고 컨티뉴.
		else if( now.count == islandc-1) { maxlen = Math.min(maxlen, now.len); return; }
			
		if(visited[now.r][now.c]) return;
		visited[now.r][now.c] = true;
		System.out.println("현위치 : " + now.r + " " + now.c + ", 현재 길이 : " + now.len);
		
		for(int d = 0; d < 4; d++) {
			int nr = now.r + dr[d];
			int nc = now.c + dc[d];
			// 범위 컷.
			if(map[nr][nc] == 2) continue;
			
			// 주변이 0일 떄와 1일 때로 나눠서, 
			switch(map[nr][nc]) {
			// 0일때는 가다가 1 만나는지 확인
			case 0 :
				int len = 0;
				while(map[nr][nc] == 0) {
					nr += dr[d];
					nc += dc[d];
					len++;
				}
				if(len > 2 && map[nr][nc] == 1 && !visited[nr][nc]) {
					System.out.println("큐에 넣음0 : " + nr + " " + nc + ", 길이 : " + (len + now.len) + ", 다리 수 : " + (now.count+1));
					dfs(new loc(nr, nc, len + now.len, now.count+1));
				}
				break;
			// 1일때는 방문 안했으면 큐에 넣기
			case 1 :
				if(!visited[nr][nc]) {
					System.out.println("큐에 넣음1 : " + nr + " " + nc + ", 길이 : " + now.len + ", 다리 수 : " + now.count);
					dfs(new loc(nr, nc, now.len, now.count));
				}
				break;
			}
			
		}
		// 원상복구
		visited[now.r][now.c] = false;
		System.out.println();
		
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