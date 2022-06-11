package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20040_사이클게임 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		for(int i = 0; i < N; i++) p[i] = i;

		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(parent(a) == parent(b)) {
				System.out.println(m);
				return;
			}
			union(a, b);
		}
		System.out.print(0);
	}
	public static void union(int x, int y) {
		p[parent(y)] = parent(x);
	}
	public static int parent(int x) {
		if(p[x] == x) return x;
		else return p[x] = parent(p[x]);
	}
}
