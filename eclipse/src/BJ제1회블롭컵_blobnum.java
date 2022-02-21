import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ제1회블롭컵_blobnum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long max = 0;
		for(int i = 1; i < n-1; i++) {
			long tmp = nums[i] + Math.min(nums[i-1],  nums[i+1]);
			max = Math.max(max,  tmp);
		}
		System.out.println(max);
	}
}
