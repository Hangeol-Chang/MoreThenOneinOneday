

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780_종이의개수 {
	static int[][] map;
	
	static int[] count = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(1, 1, N);
		System.out.print(count[0] + "\n" + count[1] + "\n" + count[2]);
	}
	// 시작위치와 사이즈를 받아오고, 다 같은 수인지 확인.
	public static void divide(int sr, int sc, int size) {
		int idf = map[sr][sc];
		boolean unified = true;
		
		// 다 똑같은지 체크.
		check : for(int r = sr; r < sr + size; r++)
			for(int c = sc; c < sc + size; c++)
				if(map[r][c] != idf) {
					unified = false;
					break check;
				}
		
		// 다 똑같으면 자기 위치에 1 더하고 리턴.
		if(unified) {
			count[idf + 1]++;
			return;
		}
		// 다 똑같지 않으면, 분해하기.
		else {
			int s3 = size/3;
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					divide(sr + i*s3, sc + j*s3, s3);
		}
	}
}
