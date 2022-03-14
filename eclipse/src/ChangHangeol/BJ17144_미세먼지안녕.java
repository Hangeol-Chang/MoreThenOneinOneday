package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17144_미세먼지안녕 {
	// 위쪽 공기청정기 회전방향
	// 아래쪽 공기청정기 회전방향
	static int[][][] drc = { {{0,1}, {-1,0}, {0,-1}, {1,0}}, 
							 {{0,1}, {1,0}, {0,-1}, {-1,0}} };
	static int[][] map;
	// 공기청정기의 r좌표만 저장.
	static int[] con = new int[2];
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(con[0] == 0) con[0] = i;
					else con[1] = i;
				}
			}
		}
		// 입력받기 끝.
		while(T-- > 0) {
			diffusion();
			circulation(0);
			circulation(1);
			
//			System.out.println("순환 결과");
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum+2);
	}
	public static void diffusion() {
		int[][] difmap = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] < 5) continue;
				int difamount = map[r][c]/5;
				int count = 0;
				for(int d = 0; d < 4; d++) {
					int nr = r + drc[0][d][0];
					int nc = c + drc[0][d][1];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
						count++;
						difmap[nr][nc] += difamount;
					}
				}
				map[r][c] -= count * difamount;
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] += difmap[i][j];
			}
		}
		
//		System.out.println("\n확산맵");
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(difmap[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("\n확산 결과");
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void circulation(int ite) {
		int keep = 0;
		int mod = 0;
		// (r, 1)에서 시작해서, -1을 만날 때 까지 돌림.
		int nr = con[ite] + drc[ite][mod][0];
		int nc = drc[ite][mod][1];
		while(map[nr][nc] != -1) {
			int tmp = map[nr][nc];
			map[nr][nc] = keep;
			keep = tmp;
			
			int dnr = nr + drc[ite][mod][0];
			int dnc = nc + drc[ite][mod][1];	
			if(dnr < 0 || dnr >= R || dnc < 0 || dnc >= C)
				mod = (mod+1)%4;
			nr += drc[ite][mod][0];
			nc += drc[ite][mod][1];	
		}
	}
}
