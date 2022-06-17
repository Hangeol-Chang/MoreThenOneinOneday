

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ16236_아기상어 {
	public static class shark {
		int y, x, size, eat;
		public shark() {
			size = 2;
			eat = 0;
		}
		public void move(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public void eat() {
			eat++;
			if(size <= eat) {
				eat = 0;
				size++;
			}
		}
	}
	public static class loc implements Comparable<loc> {
		int y, x, len;
		public loc(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
		
		// 거리가 같은 것들이 들어올 때, y에 대해 우선 정렬. 같으면 x로 정렬
		@Override
		public int compareTo(loc o) {
			if(this.y != o.y) { return this.y - o.y; }
			else { return this.x - o.x; }
		}
	}	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		shark sk = new shark();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					if(map[i][j] == 9) {
						sk.move(i, j);
						map[i][j] = 0;
					}
				}
			}
		}
		// 입력 완.
		
		int time = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<loc> que = new LinkedList<>();
		PriorityQueue<loc> pq = new PriorityQueue<>();
		que.add(new loc(sk.y, sk.x, 0));
		visited[sk.y][sk.x] = true; 
		
		
		// 먹을게 남아있는 한 계속 진행.
		while(!que.isEmpty()) {
			int size = que.size();
			
			boolean eat = false;
			for(int i = 0; i < size; i++) {
				loc now = que.poll();
				
				for(int d = 0; d < 4; d++) {
					int ny = now.y + dr[d];
					int nx = now.x + dc[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] > sk.size) continue;
					visited[ny][nx] = true;
					
					if(map[ny][nx] == 0 || map[ny][nx] == sk.size) 
						que.add(new loc(ny, nx, now.len + 1));
					else {
						eat = true;
						pq.add(new loc(ny, nx, now.len + 1));
					}
				}
			}
			
			if (eat) {
				loc eatloc = pq.poll();
				map[eatloc.y][eatloc.x] = 0; 
				sk.eat();
				time += eatloc.len;
				sk.move(eatloc.y, eatloc.x);
				
				pq.clear();
				que.clear();
				
				que.add(new loc(sk.y, sk.x, 0));
				
				visited = new boolean[N][N];
				visited[sk.y][sk.x] = true;
				
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++) {
//						System.out.print(map[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("시간 : " + time + ", 위치 : " + sk.y + " " + sk.x + ", 크기  : " + sk.size);
//				System.out.println();
			}
		}
		System.out.println(time);
		
	}
}























