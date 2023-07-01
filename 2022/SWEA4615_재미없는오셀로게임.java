
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4615_재미없는오셀로게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int[] bw = new int[3];
			bw[1] = 2;	//검은색 수
			bw[2] = 2;	//흰색 수
			
			//n, m 입력.
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//앞에를 x, 뒤에를 y로 보고 풀 것.
			//초기 흑돌, 백돌 배치
			int[][] board = new int[n][n];
			board[n/2	 ][n/2	  ] = 2;
			board[n/2 - 1][n/2 - 1] = 2;
			board[n/2 - 1][n/2	  ] = 1;
			board[n/2	 ][n/2 - 1] = 1;
			
			int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
			int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
			
			
			for(int c = 1; c <= m; c++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int dol = Integer.parseInt(st.nextToken());
				board[x][y] = dol;
				bw[dol]++;
				
				포 : for(int dir = 0; dir < 8; dir++) {
					int d = 0, nx = 0, ny = 0;
					//d에 1씩 더하면서 자기 돌의 위치 확인하고,
					do {
						d++;
						nx = x + d*dx[dir];
						ny = y + d*dy[dir];
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue 포;
					} while(board[nx][ny] == 3-dol);	//남의 말이 계속되는동안
					//위 와일문을 탈출할 때,
					//보드가 비어서 탈출할 수도 있고,		< 이놈을 걸러야 함.
					//검은걸 찾아서 탈출할 수도 있음.
					
					//d에서 1씩 빼면서 자기 돌로 바꾸기.
					if(board[nx][ny] == dol) {
						for(int delta = d-1; delta > 0; delta--) {
							nx = x + delta*dx[dir];
							ny = y + delta*dy[dir];
							board[nx][ny] = dol;
							bw[dol] ++;
							bw[3-dol] --;
						}
					}
				}
				//디버깅용 코드
//				for(int j = 0; j < n; j++) {
//					for(int i = 0; i< n; i++) {
//						System.out.print(board[i][j] + " ");
//					}
//					System.out.println();
//					System.out.println();
//				}
			}
			
			
			sb.append("#" + t + " " + bw[1] + " " + bw[2] + "\n");
		}
		System.out.println(sb);
	}
}
