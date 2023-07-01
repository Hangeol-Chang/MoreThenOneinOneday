

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ16954_움직이는미로탈출 {
	static int[] insert = {0, 1, 1, 1, 1, 1, 1, 1, 1, 0};
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1, 0};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1, 0};
	
	static class loc {
		int r, c;
		loc(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ref="#.";
		
		int[][] map = new int[10][10];
		int[] count = new int[10];
		for(int i = 1; i <= 8; i++) {
			String read = br.readLine();
			for(int j = 1; j <= 8; j++) {
				map[i][j] = ref.indexOf(read.charAt(j-1));
				
				// 벽의 수를 출력.
				if(map[i][j] == 0) count[i]++;
			}
		}
		int countsum = 0;
		for(int i : count) countsum += i;
		// 입력 완료.
		
		Queue<loc> que = new LinkedList<>();
		que.add(new loc(8, 1));
		
		while(!que.isEmpty()) {
			// 내가 살아있고, 벽이 없으면 도착할 수 있음.
			if(countsum == 0) { System.out.println(1); return; }

			// 같은 거리에 대해서만 돌려야 하므로, 동작 횟수를 받아옴.
			int quesize = que.size();
			
			// 한 주기 반복.
			for(int s = 0; s < quesize; s++) {
				loc now = que.poll();
				// 지금 서있는 곳이 벽이면 죽이기.
				if(map[now.r][now.c] == 0) continue;
//				System.out.println(now.r + " " + now.c);
				
				// 목표위치에 도착했으면 끝.
				if(now.r == 1 && now.c == 8) {
					System.out.println(1); return;
				}
				
				// 갈 수 있는 곳 큐에 다 넣기.
				for(int d = 0; d < 9; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(map[nr][nc] == 1) {
						que.add(new loc(nr, nc));
//						System.out.println("추가 : " + nr + " " + nc);
					}
				}
			}
			
			// 맵 내리기.
			countsum -= count[8];
			for(int i = 8; i >= 1; i--) {
				count[i] = count[i-1];
				map[i] = map[i-1];
			}
			map[1] = insert;
			
			// 디버그
//			for(int i = 1; i <= 8; i++) {
//				for(int j = 1; j <= 8; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		// 큐가 비어버리면, 불가능.
		System.out.println(0);
	}
}
