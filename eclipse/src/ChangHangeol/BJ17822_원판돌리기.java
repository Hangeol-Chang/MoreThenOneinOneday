package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 원으로  생각하지 말 것.
 * 상하좌우로 같은 수 있으면 컷.
 * x번째 원을 0시계 1반시계로 k칸 회전시킴.
 */
public class BJ17822_원판돌리기 {
	static int N, M, T, count;
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sum;

	static class loc {
		int r, c;
		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		count = N*M;
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				sum += board[i][j];
			}
		}
		
		// 입력받기 끝.
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int xsave = Integer.parseInt(st.nextToken());
			int x = xsave-1;
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// x번째 원을 d방향으로 k만큼.
			if(d == 1) k = M-k;
			
			// 회전시키기
			int[] tmparr = new int[M];
			while(x < N) {
				for(int i = 0; i < M; i++) {
					int idx = (i + k)%M;
					tmparr[idx] = board[x][i];
				}
				for(int i = 0; i < M; i++)
					board[x][i] = tmparr[i];
				x += xsave;
			}
			
//			System.out.println("회전 결과");
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
			// 중복 검사
			Queue<loc> que = new LinkedList<>();
			boolean passed = false;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					// 이미 지워진 숫자면 다음꺼
					if(board[r][c] == 0) continue;
					int num = board[r][c];
					
					// 이거랑 인접한 값이 근처에 있는지 판단.
					check(r, c, que, num);
					
					if(!que.isEmpty()) {
						passed = true;
						// 큐에 뭐가 들가 있으면,
						// 중복된거 다 잡아 지우기.
						board[r][c] = 0;
						count--;
						sum -= num;
						while(!que.isEmpty()) {
							loc location = que.poll();
							if(board[location.r][location.c] != 0 ) {								
								board[location.r][location.c] = 0; 
								count--;
								sum -= num;
								check(location.r, location.c, que, num);
							}
//							System.out.println(location.r + " " + location.c + " " + num + " " + sum);
						}
//						System.out.println("컷");
					}
				}
			}
			if(!passed) {
				// 평균 구해서 빼고 너하기
				float avg = (float) (1.0 * sum / count);
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(board[i][j] != 0) {
							if(board[i][j] < avg) {
								board[i][j]++;
								sum++;
							} else if(board[i][j] > avg) {
								board[i][j]--;
								sum--;
							}
						}
					}
				}
			}
//			System.out.println("한바퀴 결과");
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		System.out.println(sum);
	}
	public static void check(int r, int c, Queue<loc> que, int num) {
		for(int delta = 0; delta < 4; delta++) {
			int nr = r + dr[delta];
			int nc = c + dc[delta];
			if(nc < 0) nc += M;
			else if(nc >= M) nc = 0;
			
			if(nr >= 0 && nr < N) {
				if(board[nr][nc] == num) {
					que.add(new loc(nr, nc));
				}
			}
		}
	}
}
