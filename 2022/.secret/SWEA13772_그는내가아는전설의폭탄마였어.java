import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA13772_그는내가아는전설의폭탄마였어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			//입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n][];
			for(int i = 0; i< n; i++)
				board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//입력받기 끝.
			
			int[][] dr = {{0, 0, -1, 1}, {-1, -1, 1, 1}};
			int[][] dc = {{-1, 1, 0, 0}, {-1, 1, -1, 1}};
			
			int happy = 0;
			//xp가 0일떄 +계산, 1일때 x자 계산
			for(int xp = 0; xp < 2; xp++) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						int tmphappy = 0;
						
						//중심점 i, j
						tmphappy += board[i][j];
						for(int pp = 1; pp < p+1; pp++) {
							for(int d = 0; d < 4; d++) {
								int nr = i + dr[xp][d]*pp;
								int nc = j + dc[xp][d]*pp;

								if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
									tmphappy += board[nr][nc];
									//System.out.print("r:" + nr + ",c:" + nc + "  " + tmphappy + "  ");
								}
							}
						}
						//System.out.println();
						//System.out.println(i + " " + j + ", 합 : " + tmphappy);
						//System.out.println();
						
						if(happy < tmphappy) happy = tmphappy;
					}
				}
			}
			sb.append("#" + t + " " + happy + "\n");
		}
		System.out.println(sb);
	}
}
