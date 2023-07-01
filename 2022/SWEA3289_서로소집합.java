

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3289_서로소집합 {
	// 0 합집합 연산
	// 1 같은 집합인지 확인.
	static int N;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for(int i = 1; i <= N; i++) p[i] = i;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				switch(Integer.parseInt(st.nextToken())) {
				case 0 :
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 1 :
					sb.append(same(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ? 1 : 0);
				}
//				System.out.println(Arrays.toString(p));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else 		  return p[x] = findSet(p[x]);
	}
	public static void union(int x, int y) {
		
		p[findSet(y)] = findSet(x);
	}
	public static boolean same(int x, int y) {
		return findSet(x) == findSet(y);
	}
}

/*

2
10 5
0 1 7
0 1 6
1 6 7
0 4 1
1 4 7
1000000 2
0 1 999999
1 999999 1

3
10 5
0 1 7
0 1 6
1 6 7
0 4 1
1 4 7
1000000 2
0 1 999999
1 999999 1
10 12
0 1 7
0 1 6
0 8 7
0 7 4
1 1 6
1 1 7
1 8 4
0 5 9
1 9 1
0 9 1
0 9 8
1 5 8


*/