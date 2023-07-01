

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 0의 갯수를 최대로
public class BJ14502_연구소 {
	static class loc {
		int r, c;
		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int R, C, RC;
	static int[][] inimap;
	
	static int maxsafe = 0;
	static int inisafe = 0;
	static ArrayList<loc> inivirus = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		RC = R*C;
		
		inimap = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				inimap[i][j] = Integer.parseInt(st.nextToken());
				
				if(inimap[i][j] == 0) 	   inisafe++;
				else if(inimap[i][j] == 2) inivirus.add(new loc(i, j));
			}
		}
		// 입력 완료.
		
		select(new int[3], 0, 0);
		System.out.println(maxsafe);
	}
	// 3개를 고르고,
	public static void select(int[] wallset, int sel, int idx) {
		if(sel == 3) {
			diffusevirus(wallset);
			return;
		}
		for (int i = idx; i < RC; i++) {
			wallset[sel] = i;
			select(wallset, sel+1, i+1);
		}
	}
	// 다 골라진 것들로 판단.
	public static void diffusevirus(int[] wallset) {
//		System.out.println(Arrays.toString(wallset));
		
		// 벽 쌓기.
		int[][] map = new int[R][];
		for(int i = 0; i < R; i++) map[i] = inimap[i].clone();
		for(int w : wallset) {
			int wr = w/C;
			int wc = w%C;
			if(map[wr][wc] != 0) return;
			map[wr][wc] = 1;
		}
		
		Queue<loc> que = new LinkedList<>();
		que.addAll(inivirus);
		
		int difcount = inisafe-3;
		while(!que.isEmpty()) {
			if(difcount < maxsafe) return;
			
			loc now = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = 2;
					que.add(new loc(nr, nc));
					difcount--;
				}
			}
		}
//		for(int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(difcount);
		maxsafe = Math.max(maxsafe, difcount);
	}
}
