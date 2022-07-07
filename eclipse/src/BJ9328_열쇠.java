import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9328_열쇠 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int R, C;
	static int[][] inimap;
	static HashSet<Character> inikey;
	static ArrayList<door> doors;
	
	static class door {
		int req;
		int r;
		int c;
		door(int r, int c, int req) {
			this.req = req;
			this.r = r;
			this.c = c;
		}
	}
	
	static class location {
		int r, c;
		location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			// 필요 변수 초기화.
			inimap = new int[R][C];
			doors = new ArrayList<>();
			inikey = new HashSet<>();
			
			for(int r = 0; r < R; r++) {
				String ini = br.readLine();
				for(int c = 0; c < C; c++) {
					inimap[r][c] = ini.charAt(c);
					if (inimap[r][c] >= 'A' && inimap[r][c] <= 'Z')
						// 소문자로 바꿔서 넣음.
						doors.add(new door(r, c, inimap[r][c] + 32));
				}
			}
			// 키 입력받아서, 맵에서 지워버리기.
			String inkey = br.readLine();
			if(inkey != "0")
				for(char key : inkey.toCharArray())
					for( door d : doors)
						if(d.req == key)
							inimap[d.r][d.c] = '.'; 
			
			// 상하좌우 네 개의 라인에 대해서 진행.
			int maxdoc = 0;
			for(int i = 0; i < C; i++)
				for(int r = 0; r <= R; r += R-1)
					// 빈칸일때만 입장 가능.
					if(inimap[r][i] == '.')      maxdoc += circuit(r, i);
					else if(inimap[r][i] == '$') maxdoc += 1 + circuit(r, i);
			
			for(int i = 1; i < R-1; i++)
				// c = 0; c = C-1에 대해 진행.
				for(int c = 0; c <= C; c += C-1)
					if(inimap[i][c] == '.') 	 maxdoc += circuit(i, c);
					else if(inimap[i][c] == '$') maxdoc += 1 + circuit(i, c);
			
			sb.append(maxdoc + "\n");
		}
		System.out.print(sb);
	}
	
	public static int circuit( int sr, int sc) {
		Queue<location> que = new LinkedList<>();
		que.add(new location(sr, sc));
		
		// 맵, 키 복사세팅
		int[][] map = new int[R][];
		for(int i = 0; i < R; i++) map[i] = inimap[i].clone();
		
//		System.out.println("start at : " + sr + " " + sc);
		
		int doccount = 0;
		// 루프 시작.
		while(!que.isEmpty()) {
			location loc = que.poll();
			
			// 방문처리.
			map[loc.r][loc.c] = '!';
			
			// 열쇠를 찾았을 때, 열쇠 주변에 갔던 적이 있으면, 그 위치를 재방문시킴.
			for(int d = 0; d < 4; d++) {
				int nr = loc.r + dr[d];
				int nc = loc.c + dc[d];
				
				// 이동할 수 없으면 막기.
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || 
						map[nr][nc] == '*' || map[nr][nc] == '!' ||
						(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') ) continue;
				
				// 갈 수 있으면 que에 넣기.
				if(map[nr][nc] == '.') que.add(new location(nr, nc));
				else if(map[nr][nc] == '$') {
					map[nr][nc] = '.';
					inimap[nr][nc] = '*';
					que.add(new location(nr, nc));
					doccount++;
				}
				// 키를 발견했으면
				else {
					for(door dor : doors) {
						if(dor.req == map[nr][nc])
							map[dor.r][dor.c] = '.';
							inimap[dor.r][dor.c] = '.'; 
							for(int d2 = 0; d2 < 4; d2++) {
								int nr2 = dor.r + dr[d2];
								int nc2 = dor.c + dc[d2];
								
								if(nr2 < 0 || nr2 >= R || nc2 < 0 || nc2 >= C) continue;
								if(map[nr2][nc2] == '!') que.add(new location(nr2, nc2));
							}
					}
					map[nr][nc] = '.';
				}
				
			}
//			for(int i = 0; i < R; i++) {
//				for(int j = 0; j < C; j++) {
//					System.out.print((char) map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
//		System.out.println();
		return doccount;
	}
}

/*

1
5 17
*****************
.............**$*
*B*A*P*C**X*Y*.X.
*y*x*a*p**$*$**$*
*****************
cz

 */













