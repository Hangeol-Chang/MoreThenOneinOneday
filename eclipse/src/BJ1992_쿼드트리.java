

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992_쿼드트리 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String st = (br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}
		// 입력 완료.
		mapping(0, 0, N);
		System.out.print(sb);
	}
	public static void mapping(int sr, int sc, int size) {
		// 처리
		boolean unified = true;
		int idf = map[sr][sc];
		
		outer : for(int i = sr; i < sr + size; i++)
			for(int j = sc; j < sc + size; j++)
				if(idf != map[i][j]) {
					unified = false;
					break outer;
				}
		
		// 안타고 들어가도 되면,
		if(unified) {
			sb.append(idf);
			return;
		}
		
		// 타고 들어가야 되면
		sb.append("(");
		// 4븡분 해서 실행.
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				mapping(sr + i*size/2, sc + j*size/2, size/2);
		
		sb.append(")");
		//
	}
}
