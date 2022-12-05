

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17404_RGB거리2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료
		
		// R, G, B로 시작할 때 각각을 전부 계산.
		int[][][] coloring = new int[N][3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				coloring[1][i][j] = map[1][i] + map[0][j];
		for(int i = 0; i < 3; i++)
			coloring[1][i][i] = 2000000;
		
		// 2부터 N까지 내려가기
		for(int i = 2; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					coloring[i][j][k] = Math.min(coloring[i-1][(j+1)%3][k], coloring[i-1][(j+2)%3][k]) + map[i][j];					
				}
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == j) continue;
				pq.add(coloring[N-1][i][j]);
			}
		}
		System.out.println(pq.poll());
	}
}
