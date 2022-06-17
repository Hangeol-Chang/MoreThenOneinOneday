

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2166_다각형의면적 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] map = new long[N+1][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		map[N][0] = map[0][0];
		map[N][1] = map[0][1];
		
		long suma = 0;
		long sumb = 0;
		for(int i = 0; i < N; i++) {
			suma += map[i][0] * map[i+1][1];
			sumb += map[i][1] * map[i+1][0];
		}
		System.out.printf("%.1f",Math.abs(((suma - sumb)/2.0d)));
	}
}