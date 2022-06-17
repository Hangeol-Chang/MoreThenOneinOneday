

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분탐색 로어바운드
public class BJ2805나무자르기 {
	static int N, M;
	static int[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		// 가져갈 최소높이.
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		trees = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		System.out.println(binarysearch(0, max) - 1);
	}
	public static int binarysearch(int st, int ed) {
		if(st < ed) {
			int mid = st + (ed-st)/2;
			long ans = 0;
			// 전체 계산해봐서 리턴해주기.
			for(int tree : trees)
				ans += ( tree - mid > 0 ? tree - mid : 0);
			
			if(ans < M) return binarysearch(st, mid);
			else 		return binarysearch(mid+1, ed);
		}
		return st;
	}
}
