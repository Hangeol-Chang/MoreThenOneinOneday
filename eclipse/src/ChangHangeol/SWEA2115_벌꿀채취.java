package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취 {
	static int N, M, C;
	static int[][] mapref, map;
	static int maxearn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			mapref = new int[N+2][N+2];
			map = new int[N+2][N+2];
			for(int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 1; c <= N; c++)
					mapref[r][c] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝.
			// 각 자리에 최대 채쥐량 넣기.
			for(int r = 1; r <= N; r++)
				for(int c = 1; c <= N; c++)
					earnmax(r, c, c, 0, 0);
			
//			for(int r = 1; r <= N; r++) {
//				for(int c = 1; c <= N; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
			
			maxearn = 0;
			run(0, 0);
			
			sb.append("#" + t + " " + maxearn + "\n");
		}
		System.out.println(sb);
	}
	// 각 위치에서 얻을 수 있는 최대치를 계산.
	public static void earnmax(int r, int c, int idx, int sum, int refsum) {
		// 고생을 사서 하는구나 한걸아
		if( idx > N || idx-c >= M) { 
			map[r][c] = Math.max(sum, map[r][c]);
			return;
		}
		
		for(int j = idx; j < c+M; j++) {
			if(j > N) return;
			// 이번 수 안더하고 넘기기.
			earnmax(r, c, j+1, sum, refsum);
			// 합친게 얻을 수 있는 양보다 크면 다음꺼로.
			if(refsum + mapref[r][j] > C) { continue; }
			
			earnmax(r, c, j+1, sum + mapref[r][j]*mapref[r][j], refsum + mapref[r][j]);
		}
	}
	
	public static void run(int count, int sum) {
		if(count == 2) {
			maxearn = Math.max(maxearn, sum);
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(maxearn + " " + sum + "\n");
			return;
		}
		
		for(int r = 1; r <= N; r++) {
			inner : for(int c = 1; c <= N; c++) {
				for (int p = c; p < c+M; p++) {					
					if(p > N) break;
					if(map[r][p] == 0) continue inner;
				}
				// 하나 고르고,
				int tmpsum = map[r][c];
				
				// 그거에 해당하는 범위 싹다 0처리
				int[] tmp = insert(new int[M], r, c);
				
//				System.out.println(r + " " + c);
				
			
				// 다음꺼 찾기.
				run(count+1, sum + tmpsum);
				// 되돌려놓기
				insert(tmp, r, c);
			}
			
		}
	}
	public static int[] insert(int[] val, int r, int c) {
		for(int j = c; j < c+M; j++) {
			if(j > N) break;
			int tmp = map[r][j];
			map[r][j] = val[j-c];
			val[j-c] = tmp;
		}
		return val;
	}
}

/*

1
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7

1
4 1 10
8 1 8 2
4 6 1 6
4 9 6 3
7 4 1 3

1
9 4 20
5 2 4 8 3 7 6 2 1
7 9 8 5 8 2 6 3 6
1 9 4 6 7 5 3 1 1
4 4 7 6 2 2 8 1 7
9 6 8 5 7 3 7 9 5
7 3 1 4 1 1 8 5 3
4 6 8 9 4 5 3 8 8
1 3 4 2 4 1 1 3 6
5 9 2 3 5 2 4 8 5

1
4 3 12
8 8 6 5
5 2 7 4
8 5 1 7
7 8 9 4


*/