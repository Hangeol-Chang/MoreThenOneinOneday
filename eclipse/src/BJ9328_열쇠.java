import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9328_열쇠 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int R, C;
	static int[][] map;
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
			map = new int[R+2][C+2];
			doors = new ArrayList<>();
			
			for(int r = 1; r <= R; r++) {
				String ini = br.readLine();
				for(int c = 1; c <= C; c++) {
					map[r][c] = ini.charAt(c-1);
					if (map[r][c] >= 'A' && map[r][c] <= 'Z')
						// 소문자로 바꿔서 넣음.
						doors.add(new door(r, c, map[r][c] + 32));
				}
			}

			// 키 입력받아서, 
			// 맵에서 문 지워버리기.
			String inkey = br.readLine();
			if(inkey != "0")
				for(char key : inkey.toCharArray())
					for(door d : doors) if(d.req == key) map[d.r][d.c] = '.'; 
			
			// 상하좌우 네 개의 라인에 대해서 진행.
			int maxdoc = 0;
			for(int i = 1; i <= C; i++)
				for(int r = 1; r <= R; r += R-1)
					if( (map[r][i] >= 'a' && map[r][i] <= 'z') || map[r][i] == '.' || map[r][i] == '$')
						maxdoc += circuit(r, i);
			
			for(int i = 2; i < R; i++)
				// c = 0; c = C-1에 대해 진행.
				for(int c = 1; c <= C; c += C-1)
					if( (map[i][c] >= 'a' && map[i][c] <= 'z') || map[i][c] == '.' || map[i][c] == '$')
						maxdoc += circuit(i, c);
			
			sb.append(maxdoc + "\n");
		}
		System.out.print(sb);
	}
	
	public static int circuit( int sr, int sc) {
		Queue<location> que = new LinkedList<>();
		que.add(new location(sr, sc));
		
//		System.out.println("start at : " + sr + " " + sc);
		int doccount = 0;
		
		// 초기값에 대한 처리.
		// 문서 먹으면 +1
		if(map[sr][sc] == '$') doccount++;
		// 열쇠를 만났으면 
		else if(map[sr][sc] >= 'a' && map[sr][sc] <= 'z') que.addAll(opendoor(map[sr][sc]));

		map[sr][sc] = 0;
		
		// 루프 시작.
		while(!que.isEmpty()) {
//			for(int i = 0; i <= R+1; i++) {
//				for(int j = 0; j <= C+1; j++) {
//					System.out.print( map[i][j] == 0 ? "0 " :  (char)map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			location loc = que.poll();
			map[loc.r][loc.c] = 0; 
			
//			System.out.println("loc " + loc.r + " " + loc.c + "\n\n");
			// 열쇠를 찾았을 때, 열쇠 주변에 갔던 적이 있으면, 그 위치를 재방문시킴.
			for(int d = 0; d < 4; d++) {
				int nr = loc.r + dr[d];
				int nc = loc.c + dc[d];
				
				// 이동할 수 없으면 막기.
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || 
						map[nr][nc] == '*' || map[nr][nc] == 0 ||
						(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') ) continue;
				
				// 갈 수 있으면 que에 넣기.
				if(map[nr][nc] == '$') { doccount++; }
				// 키를 발견했으면
				else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z')
					que.addAll(opendoor(map[nr][nc]));
				
				que.add(new location(nr, nc));
				map[nr][nc] = 0;
			}
		}
//		System.out.println();
		return doccount;
	}

	static LinkedList<location> opendoor(int val) {
		LinkedList<location> que = new LinkedList<>();
		
		for(door dor : doors)
			if(dor.req == val) {
				map[dor.r][dor.c] = '.';
				
				for(int d2 = 0; d2 < 4; d2++) {
					int nr2 = dor.r + dr[d2];
					int nc2 = dor.c + dc[d2];

					if(map[nr2][nc2] == 0) que.add(new location(dor.r, dor.c));
				}
			}
		return que;
	}
}

/*

6
5 17
*****************
.............**$*
*B*A*P*C**X*Y*.X.
*y*x*a*p**$*$**$*
*****************
cz
7 7
*****$*
..*...*
*B*...*
*$*...*
***..*b
......*
......*
0
4 5
*A***
*$*a.
**$**
**A**
0
4 5
*A***
*$*.a
**$**
**A**
0
3 3
***
*$*
***
0
5 10
**********
ABCDEF$**a
**********
*********c
**d*e*f*b*
0

1
15 15
**$*.**********
****.*******$**
****B.$****b.**
$*****c*****.**
*C$.*****fD..**
*$*xd******.**$
$.C********A.**
**h********.AA.
***************
***.i**********
***.***.K$*****
*k.$$I.$*******
******.$..j***$
*******D*******
****$**F*******
za


 */













