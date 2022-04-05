package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ15656_N과M7 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		
		functionname("", 0);
		System.out.println(sb);
	}
	
	
	public static void functionname(String ssb, int count) {
		if(count == m) {
			sb.append(ssb + "\n");
			return;
		}

		for(int i = 0; i < n; i++) {
			functionname(ssb + nums[i] + " ", count+1);
		}
	}
}