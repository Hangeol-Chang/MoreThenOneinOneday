

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
		for(int i = 0; i < N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken()); 
			// 나보다 작은 것들 중에 최대
			int maxtmp = 0;
			for(int j = 0; j <= i; j++) {
				if(arr[j] < arr[i]) {
					maxtmp = Math.max(maxtmp,  maxcount[j]);
				}
			}
			maxcount[i] = maxtmp+1;
			maxnum = Math.max(maxcount[i], maxnum);
		}
		
		System.out.println(maxnum);
	}
}

/*

10
1 3 111 5 6 7 8 9 20 10

15
1 2 5 6 7 8 9 10 3 4 5 6 7 8 9

*/