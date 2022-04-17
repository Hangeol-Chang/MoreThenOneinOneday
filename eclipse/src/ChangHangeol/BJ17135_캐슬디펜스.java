package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 궁수 배치.
// 배치가 다 끝난 이후에 게임 진행.
public class BJ17135_캐슬디펜스 {
	static int[][] map;
	static int N, M, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
	}
	public static void setarcher(int[] loc, int idx) {
		if(idx == 3) {
			game(loc);
			return;
		}
		for(int i = idx; i < M; i++) {
			loc[idx] = i;
			setarcher(loc, idx+1);
		}
	}
	public static void game(int[] loc) {
		// 쏠 수 있는 적이 하나도 없으면 바로 리턴.
	}
}
