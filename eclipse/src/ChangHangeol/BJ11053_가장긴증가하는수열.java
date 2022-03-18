package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053_가장긴증가하는수열 {
	static int[] arr;
	static int[] maxcount;
	static int N;
	static int maxnum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		maxcount = new int[N];
		for(int i = 0; i < N; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
		
		dlfma(0, 0, 0);
		System.out.println(maxnum);
	}
	public static void dlfma(int count, int idx, int saved) {
		if(idx == N) {
			maxnum = Math.max(maxnum,  count);
			return;
		}
		// 이걸 가지고 넘어가거나, 안가지고 넘어가거나.
		if(saved < arr[idx]) {
			// 가지고 넘어가는 코드
			dlfma(count+1, idx+1, arr[idx]);
		}
		// 안가지고 넘어가는 코드
		dlfma(count, idx+1, saved);
	}
}

/*

10
1 3 111 5 6 7 8 9 20 10

15
1 2 5 6 7 8 9 10 3 4 5 6 7 8 9

*/