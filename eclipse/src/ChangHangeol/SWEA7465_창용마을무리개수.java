package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리개수 {
	static int[] p;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 배열을 만들고, 자기 자신을 참조하도록 함.
			p = new int[N+1];
			for(int i = 1; i <= N; i++) p[i] = i;
			
			// 유니온
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//				System.out.println(Arrays.toString(p));
			}
			
			// 그룹 세기
			HashSet<Integer> count = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				count.add(p[i]);
			}
			
			sb.append("#" + t + " " + count.size() + "\n");
		}
		System.out.println(sb);
	}
	public static void Union(int x, int y) {
		int tmp = p[y];
		p[y] = find_set(x);
		if(tmp != p[y])
			for(int i = 1; i <= N; i++)
				if(p[i] == tmp) p[i] = p[y];
	}
	public static int find_set(int a) {
		if(p[a] == a) return a;
		else {
			p[a] = find_set(p[a]);
			return p[a];
		}
	}
}
