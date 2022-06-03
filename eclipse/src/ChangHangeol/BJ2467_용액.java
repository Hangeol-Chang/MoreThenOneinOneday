package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BJ2467_용액 {
	static int[] nums;
	static int[] ans = new int[2];
	static int prop = Integer.MAX_VALUE;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[N];
		
		select(0, 0, new int[2]);
		System.out.print(ans[0] + " " + ans[1]);
	}
	public static void select(int sel, int idx, int[] selected) {
		if(sel == 2) {
			int tmpprop = selected[0] + selected[1];
			if(Math.abs(tmpprop) < prop) {
//				System.out.println(tmpprop + " | " + selected[0] + " " + selected[1]);
				ans[0] = selected[0];
				ans[1] = selected[1];
				prop = Math.abs(tmpprop);
			}
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[sel] = nums[i];
			select(sel+1, i+1, selected);
			visited[i] = false;
		}
	}
}

/*

-100 -90 -45 -12 -1 1 3 8 11 15 20
-190 -145 -112 -101 -99 -97 -92 -89

-100 -2 -1 103
-102 -101 2

완탐으로, 합이 음수일 때 아래껄 올리고, 양수일 때 위에껄 내리고,

*/