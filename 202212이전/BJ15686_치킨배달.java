

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15686_치킨배달 {
	static int N, M, chisize;
	static int[][] map;
	static int min = -1;
	
	public static class loc {
		int y, x;
		public loc (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static ArrayList<loc> chiloc = new ArrayList<>();
	static ArrayList<loc> homloc = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) 	  homloc.add(new loc(i, j));
				else if(tmp == 2) chiloc.add(new loc(i, j));
			}
		}
		chisize = chiloc.size();
		selectchi(new ArrayList<loc>(), 0);
		
		System.out.println(min);
	}
	public static void selectchi(ArrayList<loc> select, int idx) {
		if(select.size() == M) {
			calcdistance(select);
			return;
		}else if(idx >= chisize) return;
		
		// 배열 조지면 안되니까 깊은 복사가 필요함.
		ArrayList<loc> newselect = new ArrayList<>();
		newselect.addAll(select);
		
		// idx번 치킨집을 포함하는 것과 아닌 것 두개 실행.
		selectchi(newselect, idx+1);
		newselect.add(chiloc.get(idx));
		selectchi(newselect, idx+1);
		
	}
	public static void calcdistance(ArrayList<loc> selectchiloc) {
		// 모든 집들에 대해
		int distancesum = 0;
		for(loc hom : homloc) {
			int distance = -1;
			// 모든 치킨집을 돌며, 최소거리 찾기.
			for(loc chi : selectchiloc) {
				int tmpdist = Math.abs(hom.y - chi.y) + Math.abs(hom.x - chi.x);
				if(distance == -1) distance = tmpdist;
				else			   distance = Math.min(distance, tmpdist);
			}
			distancesum += distance;
		}
		if(min == -1) min = distancesum;
		else		  min = Math.min(min,  distancesum);
	}
}
