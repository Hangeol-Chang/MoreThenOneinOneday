package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 궁수 배치.
// 배치가 다 끝난 이후에 게임 진행.
public class BJ17135_캐슬디펜스 {
	static class Enemy {
		int r, c;
		Enemy(int r, int c){
			this.r = r; this.c = c;
		}
		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]\n";
		}
		
	}
	static class dist implements Comparable<dist>{
		int rd, cd, c, d, idx;
		dist(int rd, int cd, int c, int idx){
			this.rd = rd;
			this.cd = cd;
			this.c = c;
			d = rd + cd;
			this.idx = idx;
		}
		@Override
		public int compareTo(dist o) {
			if(this.d != o.d) return this.d - o.d;
			else 			  return this.c - o.c;
		}
		@Override
		public String toString() {
			return "dist [rd=" + rd + ", cd=" + cd + ", d=" + d + ", idx=" + idx + "]";
		}
		
	}
	static HashMap<Integer, Enemy> enemylocref = new HashMap<>();
	static int N, M, D, enemys, maxkill;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		maxkill = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) { enemylocref.put(enemys++, new Enemy(i, j)); }
			}
		}
		// 입력 완료.

		setarcher(new int[3], 0, 0);
		System.out.println(maxkill);
	}
	public static void setarcher(int[] loc, int idx, int idf) {
		if(maxkill == enemys) return;
		if(idx == 3) {
//			System.out.println(Arrays.toString(loc));
			game(loc);
			return;
		}
		for(int i = idf; i < M; i++) {
			loc[idx] = i;
			setarcher(loc, idx+1, i+1);
		}
	}
	public static void game(int[] loc) {
		int kill = 0;
		
		// 적 배열 복사해오기.
		HashMap<Integer, Enemy> enemyloc = new HashMap<>();
		for(Map.Entry<Integer, Enemy> entry : enemylocref.entrySet()) {
			Enemy tmp = entry.getValue();
			enemyloc.put(entry.getKey(), new Enemy(tmp.r, tmp.c));
		}
		
//		System.out.println("\n시작");
		
		// 적이 들어오건 죽건, 적이 다 사라질때 까지 반복.
		while(enemyloc.size() > 0) {
			// 쏘기
			HashSet<Integer> shootloc = new HashSet<>();
			// 각 사람이 쏠 사람 정하기.
			for(int s = 0 ; s < 3; s++) {
				PriorityQueue<dist> pq = new PriorityQueue<>();
				// 적에 대한거 다 넣기.
				for(Map.Entry<Integer, Enemy> entry : enemyloc.entrySet()) {
					int key = entry.getKey();
					Enemy e = entry.getValue();
					int dr = N - e.r;
					int dc = Math.abs(loc[s] - e.c);
					
					if(dr + dc <= D)
						pq.add(new dist(dr, dc, e.c, key));
				}
				
//				System.out.println(pq.toString());
				// 제일 쏘기 좋은거 넣기.
				if(!pq.isEmpty())
					shootloc.add(pq.poll().idx);
			}
			
			for(int idx : shootloc) {
				enemyloc.remove(idx);
				kill++;
			}
			
			// 적 이동.
			ArrayList<Integer> tmpl = new ArrayList<>();
			for(Map.Entry<Integer, Enemy> entry : enemyloc.entrySet()) {
				if(++entry.getValue().r >= N)
					tmpl.add(entry.getKey());
			}
			for(int tmp : tmpl)
				enemyloc.remove(tmp);
			
//			System.out.println("현재 위치 : " + Arrays.toString(loc) + ", 킬수 : " + kill);
//			System.out.println("남은 적 : \n" + enemyloc.toString());
		}
		maxkill = Math.max(kill, maxkill);
	}
}
