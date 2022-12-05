

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 주변 지뢰를 전부 찾아 놓고,
// 0과 이어지는 것을 세기
public class SWEA1868_파핑파핑지뢰찾기2 {
	static int[][] map;
	static boolean[][] visited;
	static int n, count;
	
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static class node{
		int y, x, mine;
		public node(int y, int x, int mine) {this.y = y; this.x = x; this.mine = mine;}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> ref = new HashMap<>();
		ref.put('.', 0);
		ref.put('*', 9);
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			n = Integer.parseInt(br.readLine());

			map = new int[n+2][n+2];
			for(int i = 0; i <= n+1; i++) { Arrays.fill(map[i], 10); }
			
			// 내가 눌러야 하는 총량.
			count = (int) Math.pow(n, 2);
			for(int i = 1; i <= n; i++) {
				String st = (br.readLine());
				for(int j = 1; j <= n; j++) {
					map[i][j] = ref.get(st.charAt(j-1));
					// 지뢰는 클릭 안해도 되지 빼 놓음.
					if(map[i][j] == 9) {count--;}
				}
			}
			
			// 입력받기 끝.
			// 각 위치에 지뢰 수 입력.
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= n; j++)
					if(map[i][j] < 9) map[i][j] = countmine(i, j);

			
			for(int y = 1; y <= n; y++) {
				for(int x = 1; x <= n; x++) {
					// 지뢰가 아닌 것들에 대해 전부 돌려서 클릭 양을 뺌.
					if(map[y][x] == 0) click(y,x, map[y][x]);
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

	
	public static void click(int y, int x, int mine) {		
		Queue<node> que = new LinkedList<>();
		// 클릭지점을 큐에 추가.
		que.add(new node(y, x, mine));
		// 이곳에 다시 올 수 없도록 -1을 배치
		map[y][x] = -1;
		
		while(!que.isEmpty()) {			
			node now = que.poll(); 
			
			// 주변에 지뢰가 없으면, 주변을 큐에 전부 추가.
			if(now.mine <= 0) {
				
				for(int d = 0 ; d < 8; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					// 주변 중에서 안가본 곳만.
					if(map[ny][nx] < 9 && map[ny][nx] >= 0) {
						que.add(new node(ny, nx, map[ny][nx]));
						// 재방문 막기.
						map[ny][nx] = -1;
						// 내가 누를 게 하나 줄어듬.
						count--;
					}
				}
			}
		}
	}
	
	// 내 주변 지뢰 찾아주는 함수.
	public static int countmine(int y, int x) {
		int minecount = 0;
		for(int d = 0 ; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(map[ny][nx] == 9) minecount++;
		}
		return minecount;
	}
}

/*
2
3
..*
..*
**.
5
..*..
..*..
.*..*
.*...
.*...

*/