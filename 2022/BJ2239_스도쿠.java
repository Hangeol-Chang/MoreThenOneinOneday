

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2239_스도쿠 {
	public static int[][] map = new int[9][9];
	public static int[] rowbit = new int[9];
	public static int[] colbit = new int[9];
	public static int[] mapbit = new int[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			String line = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
				
				if(map[i][j] != 0) {
					colbit[j] = colbit[j] | 1<<map[i][j];
					rowbit[i] = rowbit[i] | 1<<map[i][j];
					mapbit[getidx(i, j)] = mapbit[getidx(i, j)] | 1<<map[i][j];
				}
			}
		}
		// 입력 완료
		
		solve(0);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static boolean solve(int rc) {		
		// 넣을 위치 찾기
		while ( rc < 81 && map[rc/9][rc%9] != 0) rc++;
		if(rc >= 81) return true;
		
		int r = rc/9;
		int c = rc%9;
		
		for(int i = 1; i <= 9; i++) {
			// 넣을 수 없는 상황이면 다음걸로
			if(		(rowbit[r] & 1<<i) > 0 ||
					(colbit[c] & 1<<i) > 0 ||
					(mapbit[getidx(r, c)] & 1<<i) > 0)
				continue;
			
			// 넣기
			map[r][c] = i;
			rowbit[r] = rowbit[r] | 1<<i;
			colbit[c] = colbit[c] | 1<<i;
			mapbit[getidx(r, c)] = mapbit[getidx(r, c)] | 1<<i;
			// 만약 지금 했던걸로 결과가 나오면, 여기서 맨 처음까지 리턴해버림.
			if( solve(rc+1) ) return true;
			
			// 통과 못했으면, 원위치
			map[r][c] = 0;
			rowbit[r] = rowbit[r] ^ 1<<i;
			colbit[c] = colbit[c] ^ 1<<i;
			mapbit[getidx(r, c)] = mapbit[getidx(r, c)] ^ 1<<i;
		}
		// 아무것도 못넣으면 불가능
		return false;
	}
	
	// mapbit의 인덱스를 반환해주는 함수
	private static int getidx(int i, int j) {
		return (i/3)*3 + j/3;
	}
}