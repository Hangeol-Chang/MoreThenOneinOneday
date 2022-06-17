

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0은 빈칸. 1~5는 cctv, 6은 벽,
 * cctv끼리는 통과 가능
 */

public class BJ15683_감시 {
	static int R;
	static int C;
	// 1, 2, 3, 4, 5 번에 대해 foreach문으로 가져와서 사용할 것임.
	// [cctv번호][회전 번호(foreach로 가져와야 하는 부분][방향의 수][x]
	static int[][][][] drc = { {{{}}},
							   { {{1,0}},{{0,1}},{{0,-1}},{{-1,0}} },
	 						   { {{1,0},{-1,0}},{{0,1},{0,-1}} },
	 						   { {{1,0},{0,1}},{{0,1},{-1,0}},{{0,-1},{-1,0}},{{1,0},{0,-1}} },
	 						   { {{1,0},{0,1},{-1,0}},{{0,1},{-1,0},{0,-1}},{{0,-1},{-1,0},{1,0}},{{1,0},{0,-1},{0,1}} },
	 						   { {{1,0},{0,1},{-1,0},{0,-1}} } 
	 					   };
	static int mincount = 0;
	/*
	 * {{1,0}},{{0,1}},{{0,-1}},{{0,1}}
	 * {{1,0},{-1,0}},{{0,1},{0,-1}}
	 * {{1,0},{0,1}},{{0,1},{-1,0}},{{0,-1},{-1,0}},{{1,0},{0,-1}}
	 * {{1,0},{0,1},{-1,0}},{{0,1},{-1,0},{0,-1}},{{0,-1},{-1,0},{1,0}},{{1,0},{0,-1},{1,0}}
	 * {{1,0},{0,1},{-1,0},{1,0}}
	 */
	static class loc {
		int y, x, num;
		public loc(int y, int x, int num) {
			this.y = y;
			this.x = x;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<loc> que = new LinkedList<>();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) mincount++;
				else if(map[i][j] < 6) que.add(new loc(i, j, map[i][j]));
			}
		}
		// 입력받기 끝.
		search(que, mincount, map);
		System.out.println(mincount);
	}
	public static void search(Queue<loc> que, int count, int[][] map) {
		if(!que.isEmpty()) {
			// 깊은 복사로 큐 가져옴.
			Queue<loc> newque = new LinkedList<>();
			newque.addAll(que);
			loc cctvdata = newque.poll();
			
			// cctv가 돌 수 있는 모든 방향에 대해.
			for(int[][] cctv : drc[cctvdata.num]) {
				// 한 방향에 대한 처리.
				// 깊은복사로 맵 가져옴.
				int[][] newmap = new int[R][C];
				for(int i = 0; i < R; i++)
					for(int j = 0; j < C; j++) 
						newmap[i][j] = map[i][j];
				
				int newcount = count;
				for(int[] delta : cctv) {
//					System.out.println(delta[0] + " " + delta[1]);
					// 0번인덱스가 y, 1번인덱스가 x를 처리함.
					int d = 0;
					while(true) {
						d++;
						int ny = cctvdata.y + delta[0]*d;
						int nx = cctvdata.x + delta[1]*d;
						if(nx >= 0 && nx < C && ny >= 0 && ny < R) {
							if(newmap[ny][nx] == 6) break;
							else if(newmap[ny][nx] == 0 ) {
								newmap[ny][nx] = 7;
								newcount--;
							}
						}else break;
					}
				}
				
				// 디버그 코드
//				for(int i = 0; i < R; i++) {
//					for(int j = 0; j < C; j++) {
//						System.out.print(newmap[i][j] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println(count + ", 최소는 :  " + mincount);

				search(newque, newcount, newmap);
			}
		}
		else {
			mincount = Math.min(mincount, count);
		}
	}
}

/*

*/