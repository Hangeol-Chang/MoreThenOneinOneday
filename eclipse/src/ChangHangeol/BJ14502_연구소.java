package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int R, C;
	static int[][] inimap;
	
	static int maxsafe = 0;
	static int inisafe = 0;
	static ArrayList<loc> inivirus = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
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
		
		select(new loc[3], 0);
		System.out.println(maxsafe);
	}
	// 3개를 고르고,
	public static void select(loc[] wallset, int sel) {
		
	}
	// 다 골라진 것들로 판단.
	public static void diffusevirus(loc[] wallset) {
		
		Queue<loc> que = new LinkedList<>();
		que.addAll(inivirus);
		
		while(!que.isEmpty()) {
			
		}
	}
}
