
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ제1회블롭컵_blobnum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			max = Math.max(nums[i], max);
		}

		for(int i = 1; i < n-1; i++) {
			int tmp = nums[i] + Math.min(nums[i-1],  nums[i+1]);
			max = Math.max(max,  tmp);
		}
		System.out.print(max);
	}
}

/*

1
10

6
2 7 3 10 2 4


 */