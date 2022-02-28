package ChangHangeol;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BJ11399_ATM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		
		int[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		int sum = nums[0];
		for(int i = 1; i < n; i++) {
			nums[i] += nums[i-1];
			sum += nums[i];
		}
		System.out.println(sum);
		in.close();
	}
}
