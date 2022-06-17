

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 벽에 박으면 그 때 점수를 계산.
public class SWEA5650_핀볼게임 {
	static int[] ddr = {-1, 1, 0, 0};
	static int[] ddc = {0, 0, -1, 1};
	// 또 고생을 사서 하는구나 한걸아.
	static int[][][] dir = {{{ 1, 0},{-1, 0},{ 0, 0},{ 0,-1},{ 0, 1}},
							{{ 0, 1},{ 1, 0},{ 0, 0},{ 0,-1},{-1, 0}},
							{{ 0,-1},{ 0, 1},{ 0, 0},{ 1, 0},{-1, 0}},
							{{ 1, 0},{ 0, 1},{ 0, 0},{-1, 0},{ 0,-1}}};
	static int N, maxscore;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			// 맵을 벽으로 채우고 시작.
			for(int i = 0; i <= N+1; i++) Arrays.fill(map[i], 5);
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			// 입력완료.	
			
			maxscore = 0;
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++) {
					if(map[i][j] != 0) continue;
					for(int d = 0; d < 4; d++)
						game(i, j, d);
				}
			
			sb.append("#" + t + " " + maxscore + "\n");
		}
		System.out.print(sb);
	}
	public static void game(int r, int c, int d) {
		int score = 0;
		int dr = ddr[d];
		int dc = ddc[d];
		int nr = r + dr;
		int nc = c + dc;
		
		// 내 자리에 돌아오거나, 블랙홀을 만나지 않는 한 계속.
		while(!(nr == r && nc == c) && map[nr][nc] != -1) {
			// dr, dc를 수정.
			switch(map[nr][nc]) {
			// dr, dc, map값을 이용해 16개의 배열값을 얻어옴.
			// 이를 이용해서 4개 케이스를 한번에 처리.
			case 1 :
			case 2 :
			case 3 :
			case 4 :
				// idf1이 0, 1, 2, 3으로 나옴.
				// idf2는 0, 1, 2, 3, 4 로 나옴.
//				System.out.println(nr + " " + nc + " " + dr + " " + dc);
				int idf1 = map[nr][nc]-1;
				int idf2 = dr*2 + dc + 2;
				dr = dir[idf1][idf2][0];
				dc = dir[idf1][idf2][1];
				score++;
				break;
			// 벽
			case 5 :
				dr *= -1;
				dc *= -1;
				score++;
				break;
			// 웜홀 한번에 처리.
			case 6 :
			case 7 :
			case 8 :
			case 9 :
			case 10 :
				oyes : for(int rr = 1; rr <= N; rr++)
					for(int cc = 1; cc <= N; cc++)
						if(map[rr][cc] == map[nr][nc] && (rr != nr || cc != nc)) {
								nr = rr;
								nc = cc;
								break oyes;
							}
				break;
			default :
				break;
			}
			nr += dr;
			nc += dc;
		}
		maxscore = Math.max(score, maxscore);
	}
}

/*

1
10
0 4 0 0 0 0 4 0 5 0 
0 0 0 0 0 0 0 0 3 0 
0 0 0 5 6 0 0 0 0 2 
3 0 0 1 0 0 1 4 0 2 
2 0 0 0 0 5 0 0 5 0 
0 0 1 0 2 0 0 0 5 0 
0 0 0 0 0 0 6 1 0 0 
0 0 1 0 2 0 2 4 0 0 
0 0 0 0 0 0 2 0 0 0 
2 0 0 0 0 0 0 3 0 0 


*/