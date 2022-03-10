package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ1182_부분수열의합 {
	static int count = 0;
	static int n;
	static int s;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		powerset(0, 0);
		if(s == 0) count--;
		System.out.println(count);
	}
	public static void powerset(int sum, int idx) {
		if(idx == n) {
			if(sum == s) {
				count++;
			}
			return;
		}
		powerset(sum, idx + 1);
		powerset(sum + nums[idx], idx + 1);
	}
}
