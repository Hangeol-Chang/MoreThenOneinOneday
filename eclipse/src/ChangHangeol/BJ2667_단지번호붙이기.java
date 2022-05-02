package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String ref = br.readLine();
			for(int j = 0; j < N; j++)
				map[i][j] = ref.charAt(j) - '0';
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					pq.add(crash(i, j));
				}
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	public static int crash(int i, int j) {
		int count = 1;
		map[i][j] = 0;
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i, j});
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0) continue;
				map[nr][nc] = 0;
				que.add(new int[] {nr, nc});
				count++;
			}
		}
		return count;
	}
}
