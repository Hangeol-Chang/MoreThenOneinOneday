package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2096_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료.
		int[][] maxmap = new int[2][3];
		int[][] minmap = new int[2][3];
		maxmap[0][0] = map[0][0];
		maxmap[0][1] = map[0][1];
		maxmap[0][2] = map[0][2];
		
		minmap[0][0] = map[0][0];
		minmap[0][1] = map[0][1];
		minmap[0][2] = map[0][2];
		
		for(int i = 1; i < N; i++) {
			maxmap[1][0] = map[i][0] + Math.max(maxmap[0][0], maxmap[0][1]);
			maxmap[1][1] = map[i][1] + Math.max(maxmap[0][0], Math.max(maxmap[0][1], maxmap[0][2]));
			maxmap[1][2] = map[i][2] + Math.max(maxmap[0][1], maxmap[0][2]);

			minmap[1][0] = map[i][0] + Math.min(minmap[0][0], minmap[0][1]);
			minmap[1][1] = map[i][1] + Math.min(minmap[0][0], Math.min(minmap[0][1], minmap[0][2]));
			minmap[1][2] = map[i][2] + Math.min(minmap[0][1], minmap[0][2]);
			
			minmap[0] = minmap[1].clone();
			maxmap[0] = maxmap[1].clone();
		}
		int min = Math.min(minmap[0][0], Math.min(minmap[0][1], minmap[0][2]));
		int max = Math.max(maxmap[0][0], Math.max(maxmap[0][1], maxmap[0][2]));
		System.out.print(max + " " + min);
	}
}
