

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ2467_용액 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] ans = new int[2];
		int l = 0;
		int r = N-1;
		
		int prop = Integer.MAX_VALUE;
		
		while(l < r) {
			int tmpprop = nums[l] + nums[r];
			if(prop > Math.abs(tmpprop)) {
				prop = Math.abs(tmpprop);
				ans[0] = nums[l];
				ans[1] = nums[r];
			}

			if	   (tmpprop < 0) l++;
			else if(tmpprop > 0) r--;
			else {
				// 여기 들어오면, 그냥 출력하고 끝내도 됨.
				System.out.println(nums[l] + " " + nums[r]);
				return;
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}