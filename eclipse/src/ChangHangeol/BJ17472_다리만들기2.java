package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[N+2][M+2];
		int[][] map = new int[N+2][M+2];		
		for(int i = 0; i <= N+1; i++) Arrays.fill(map[i], 2);
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++)
				map[i][j]= Integer.parseInt(st.nextToken());
		}
		// 입력 끝.
		
		// 출발위치 하나 잡아오기
		PriorityQueue<loc> pq = new PriorityQueue<>();
		outer : for(int r = 1; r <= N; r++)
			for(int c = 1; c <= M; c++)
				if(map[r][c] == 1) {
					pq.add(new loc(r, c, 0, 0));
					break outer;
				}
		// 섬의 갯수 세기
		int islandc = 0;
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
		
		// 계산 시작.
		while(true) {
			loc now = pq.poll();
			if(visited[now.r][now.c]) continue;
			visited[now.r][now.c] = true; 
			
			for(int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				// 범위 컷.
				if(map[nr][nc] == 2) continue;
				
				// 주변이 0일 떄와 1일 때로 나눠서, 
				// 0일때는 가다가 1 만나는지 확인
				// 1일때는 큐에 넣기
				switch(map[nr][nc]) {
				case 0 :
					int len = 0;
					while(map[nr][nc] == 0) {
						nr += dr[d];
						nc += dr[d];
						len++;
					}
					if(len > 0 && map[nr][nc] == 1)
						pq.add(new loc(nr, nc, len + now.len, now.count+1));
				}
			}
		}
	}
}
