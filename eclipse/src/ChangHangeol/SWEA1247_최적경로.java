package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회사에서 출발.
// 다 돌고 집에 도착
// 입력 : 회사 집 N개 집들
public class SWEA1247_최적경로 {
	static class loc{
		int y, x;
		loc(int y, int x){
			this.y = y; this.x = x;
		}
	}
	static int N, mindist;
	static loc home;
	static loc[] clients;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			loc office = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				home   = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			clients = new loc[N];
			for(int i = 0; i < N; i++) 
				clients[i] = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			mindist = Integer.MAX_VALUE;
			run(0, 0, 0, office);
			sb.append(mindist + "\n");
		}
		System.out.println(sb);
	}
	
	public static void run(int dist, int vi, int count, loc lastvisit) {
		if(dist > mindist) return;
		if(count == N) {
			dist += Math.abs(lastvisit.y - home.y) + Math.abs(lastvisit.x - home.x);
			mindist = Math.min(dist,  mindist);
		}
		for(int i = 0; i < N; i++) {
			if((vi & 1<<i) > 0) continue;
			int distmp = dist + Math.abs(clients[i].y - lastvisit.y) + Math.abs(clients[i].x - lastvisit.x);
			run(distmp, vi | 1<<i, count+1, clients[i]);
		}
	}
}	

/*
1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
*/