
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1 1 1 2 2 3 4 5 7 9 12 16 21 28 36
 * n-5의 수를 더하는 꼴
 */
public class BJ9461_파도반수열 {
	static long[] nums = new long[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(sum(n-1) + "\n");
		}
		System.out.println(sb);
	}
	
	public static long sum(int n) {
		if(n < 3) return 1;
		else if(n < 5) return 2;
		else {
			if(nums[n] == 0 ) {
				nums[n] = sum(n-1) + sum(n-5);				
			}
			return nums[n];
		}
	}
}
