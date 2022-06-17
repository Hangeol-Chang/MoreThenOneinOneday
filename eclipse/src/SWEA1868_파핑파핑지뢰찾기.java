

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 0인데서만 8칸으로 쩨면 되나?
// 숫자인데 클릭해도, 0인 곳만 가면 됨.
public class SWEA1868_파핑파핑지뢰찾기 {
	static int[][] map;
	static int n;
	
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static class node{
		int y, x;
		public node(int y, int x) {this.y = y; this.x = x;}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> ref = new HashMap<>();
		ref.put('.', -1);
		ref.put('*', 9);
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			n = Integer.parseInt(br.readLine());
			
			map = new int[n+2][n+2];
			for(int i = 0; i <= n+1; i++) Arrays.fill(map[i], 10);
			
			for(int i = 1; i <= n; i++) {
				String st = (br.readLine());
				for(int j = 1; j <= n; j++) {
					map[i][j] = ref.get(st.charAt(j-1));
				}
			}
			// 입력받기 끝.
			
			int count = 0;
			for(int y = 1; y <= n; y++) {
				for(int x = 1; x <= n; x++) {
					if(map[y][x] == -1) {
//						System.out.println(y + " " + x);
						click(y,x);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}

	
	public static void click(int y, int x) {		
		Queue<node> que = new LinkedList<>();
		// 클릭지점을 큐에 추가.
		que.add(new node(y, x));
		
		while(!que.isEmpty()) {			
			// 주변에 지뢰가 있는지, 없는지 판단.
			node now = que.poll(); 
//			System.out.println(now.y + " " + now.x);
			int minecount = countmine(now.y, now.x);
			map[now.y][now.x] = minecount;
			
			// 주변에 지뢰가 없으면, 주변을 큐에 전부 추가.
			if(minecount == 0) {
				for(int d = 0 ; d < 8; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if(map[ny][nx] == -1) {
						que.add(new node(ny, nx));
						map[ny][nx] = 0;
					}
				}
			}
			// 지뢰가 있으면 주면 위치 중 0인 곳만 넣기
			else {
				for(int d = 0 ; d < 8; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					
					if(map[ny][nx] == -1 && countmine(ny,nx) == 0) {
						que.add(new node(ny, nx));
						map[ny][nx] = 0;
					}
				}
			}
		}
	}
	
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
1
3
..*
..*
**.

*/