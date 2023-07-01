

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA6808규영이와인영이의카드게임 {
	static ArrayList<Integer> myc, yourc;
	static boolean[] visited = new boolean[9];
	static int loser, winr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			
			// 내 카드 넣기
			myc = new ArrayList<>();
			yourc = new ArrayList<>();
			for(int i = 0; i < 9; i++)   myc.add(Integer.parseInt(st.nextToken()));
			// 니 카드 넣기.
			for(int i = 1; i <= 18; i++) if(!myc.contains(i)) yourc.add(i);
			
			winr = 0;
			loser = 0;
			run(0, 0, 0);
			
			sb.append(winr + " " + loser + " " + "\n");
		}
		System.out.println(sb);
	}

	public static void run(int mys, int yours, int match) {
		if(match == 9) {
			if(mys > yours) winr++;
			else if(mys < yours) loser++;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			int m = myc.get(match);
			int y = yourc.get(i);
			
			if(m < y) run(mys, yours + m + y, match+1);
			else	  run(mys + m + y, yours, match+1);
			
			visited[i] = false;
		}
	}
}

/*
1
1 3 5 7 9 11 13 15 17

4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18
*/