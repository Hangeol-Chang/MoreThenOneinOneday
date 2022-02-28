package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ제1회블롭컵_blobyum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int nowsum = 0;
		for(int i = 0; i < m; i++) nowsum += nums[i];
		
		int max = nowsum;
		for(int i = m; i < n+m; i++) {
			nowsum -= nums[i-m];
			nowsum += nums[i%n];
			
			max = Math.max(max, nowsum);
		}
		System.out.println(max);
	}
	
}
