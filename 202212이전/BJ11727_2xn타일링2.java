
import java.util.Scanner;


public class BJ11727_2xn타일링2 {
	public static void main(String[] arsg) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n+2];
		nums[1] = 1;
		nums[2] = 3;
		System.out.println(counting(n, nums)); 
		in.close();
	}
	
	public static int counting(int n, int[] nums) {
		if(nums[n] != 0) return nums[n];
		else {
			nums[n] = (counting(n-1, nums) + 2*counting(n-2, nums))%10007;
			return nums[n];
		}
	}
}
