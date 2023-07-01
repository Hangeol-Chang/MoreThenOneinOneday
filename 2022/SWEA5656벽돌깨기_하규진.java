

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA5656벽돌깨기_하규진 {
	static class Brick {
		int x, y, cnt;

		Brick(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;// 터뜨릴수 있는 벽돌의 개수
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 구슬 개수
			W = sc.nextInt();// 가로
			H = sc.nextInt();// 세로
			map = new int[H][W];

			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					map[h][w] = sc.nextInt();
				}
			}

			// 내가 떨어뜨릴 수 있는 위치의 경우의 수를 찾기
			// 중복 순열
			count = 100000;
			for(int i = 0; i < W; i++)
				nPr(0, i, map);
			
			System.out.println(count);
		} // tc
	}// main

	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int count;// 몇개 부수었나
	
	static void nPr(int idx,int fire, int[][] firemap) {
		if(idx == N)
			return;
			// 구슬 크기만큼 뽑으면 끝 이 때 새로운 함수를 진행함
		int cnt = 0;
		
		int[][] newMap = new int[H][W];
		copy(firemap, newMap);
		
		crash(H, fire, newMap);
		
		makeDown(newMap);
		
		System.out.println("??");
		System.out.println(idx + " " + fire);
		for(int i = 0; i < H; i++){
			for(int j = 0; j < W; j++){
				System.out.print(newMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(newMap[i][j] != 0) {
					cnt++;
				}
			}
		}
		count = Math.min(count, cnt);		
		
		for (int i = 0; i < W; i++) nPr(idx + 1, i,newMap);		
	}

	static void crash(int h, int w, int[][] map) {
		int[] dr = { 1, 0, 0 };
		int[] dc = { 0, -1, 1 };
		Brick cur = null;
		for (int i = 0; i < h; i++) {
			if (map[i][w] != 0) {

				cur = new Brick(i, w, map[i][w]);
				break;// 첫 0 이 아닌 자리 찾으면 끝
			}
		}

		Queue<Brick> que = new LinkedList<>();
		que.add(cur);
		map[cur.x][cur.y] = 0; // 폭발 처리

		while (!que.isEmpty()) {
			Brick newBrick = que.poll();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < map[newBrick.x][newBrick.y] - 1; j++) {
					int nr = newBrick.x + dr[i] * j;
					int nc = newBrick.y + dc[i] * j;
					if (nr >= 0 && nc >= 0 && nr < H && nc < W) {
						que.add(new Brick(nr, nc, map[nr][nc]));
						map[nr][nc] = 0;

					}
				}
			}
		}
	}

	static void makeDown(int[][] map) {
		for (int i = 0; i < W; i++) {
			int r = H - 1;// 밑에서부터 탐색
			
			while (r > 0) {
				int nr = r - 1;
				while (nr > 0 && map[nr][i] == 0) nr--;
				
				map[r][i] = map[nr][i];
				map[nr][i] = 0;
				r--;
			}
		}
	}

	static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
