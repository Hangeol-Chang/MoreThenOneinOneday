package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026_적녹색약 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean visited[][];
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String ref = br.readLine();

			for (int j = 0; j < N; j++)
		}
		// 입력 완료


		visited = new boolean[N][N];
		int countB = bfs('B');
		int countR = bfs('R');
		int countG = bfs('G');
		
		// RG 통합
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if (map[i][j] == 'R') map[i][j] = 'G';
		
		visited = new boolean[N][N];
		int countRG = bfs('G');
		
		System.out.println((countB + countR + countG) + " " + (countB + countRG));
	}

	public static int bfs(char idf) {
		int count = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
//				System.out.println((map[r][c] != idf) + " " + map[r][c] + " " +idf);
				if (visited[r][c] || map[r][c] != idf) continue;
				
				Queue<int[]> que = new LinkedList<int[]>();
				que.add(new int[] {r, c});
				
				while(!que.isEmpty()) {
					int[] loc = que.poll();
					if(visited[loc[0]][loc[1]]) continue;
					visited[loc[0]][loc[1]] = true;
					
					for(int d = 0; d < 4; d++) {
						int nr = loc[0] + dr[d];
						int nc = loc[1] + dc[d];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						if(visited[nr][nc] || map[nr][nc] != idf) continue;
						que.add(new int[] {nr, nc});
					}
				}
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++) {
//						System.out.print(visited[i][j] ? 1 : 0);
//					}
//					System.out.println();
//				}
//				System.out.println();
				count++;
			}
		}
		return count;
	}
}
