package ChangHangeol;
import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA2817_부분수열의합 {
	static int m;
	static int count;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		in.nextLine();
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			m = in.nextInt();
			in.nextLine();
			int[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			count = 0;
			powerset(0, 0, n, nums);
			sb.append(count + "\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	static void powerset(int index, int sum, int n, int[] nums) {
		if(sum == m) { count++; return; }
		if(index < n) {
			powerset(index + 1, sum, n, nums);
			powerset(index + 1, sum + nums[index], n, nums);
		}
		return;
	}
}
