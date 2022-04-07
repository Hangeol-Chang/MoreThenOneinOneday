package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class BJ17070_파이프옮기기 {
	// 가로세로대각선 움직이고 싶을 때 각각 비엇는지 확인해야 할 장소.
	static int[][][] d = {{{0, 1}},
						  {{1, 0}},
						  {{0,1},{1,0},{1,1}}};
	static int[][] go = {{0,1},{1,0}, {1,1}};
	//각각의 상태에서 갈 수 있는 상황들.
	static int[][] cango = {{0, 2},
							{1, 2},
							{0, 1, 2}};
	static class pipe{
		int r1, r2, c1, c2;
		pipe(int r1, int c1, int r2, int c2) {
			this.r1 = r1; this.r2 = r2;
			this.c1 = c1; this.c2 = c2;
		}
		public int status() {
			// 가로로 누운 상태.
			if(r1 == r2) 	  return 0;
			// 세로 상태
			else if(c1 == c2) return 1;
			// 대각선 상태
			else			  return 2;
		}
		@Override
		public String toString() {
			return "pipe [r1=" + r1 + ", c1=" + c1 + ", r2=" + r2 + ", c2=" + c2 + "]";
		}
	}
	static boolean[][] map;
	
	//메인함수 시작.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N+2][N+2];
		// 외곽에 벽세우기. true가 막힌 상태.
		for(int i = 0; i <= N+1; i++) {
			map[0][i] = true;
			map[N+1][i] = true;
			map[i][0] = true;
			map[i][N+1] = true;
		}
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
		}
		if(map[N][N] == true) {System.out.println(0); return;}
		Queue<pipe> que = new LinkedList<>();
		que.add(new pipe(1, 1, 1, 2));
		
		int count = 0;
		while(!que.isEmpty()) {
			pipe now = que.poll();
			if(now.r2 == N && now.c2 == N) {
				count++;
				continue;
			}
			
			outer : for(int idf : cango[now.status()]) {
				for(int[] sp : d[idf]) {
					int r3 = now.r2 + sp[0];
					int c3 = now.c2 + sp[1];
					// 장애물이 있는 상태
					if(map[r3][c3] == true) continue outer;
				}
//				System.out.println(now + " " + idf);
				que.add(new pipe(now.r2, now.c2, now.r2 + go[idf][0], now.c2 + go[idf][1]));
			}
		}
		System.out.println(count);
	}
}
