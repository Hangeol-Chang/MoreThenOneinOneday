import java.util.Scanner;
/*
 * 2 2
 * 3 3
 * 4 5
 * 5 8
 * 6 13
 * 7 21
 * 8 34
 * 9 55
 * 
 * 2와 1로 만들 수 있는 양 찾기.
 */

public class BJ11726 {
	public static void main(String[] arsg) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n+2];
		nums[1] = 1;
		nums[2] = 2;
		System.out.println(counting(n, nums)); 
		in.close();
	}
	
	public static int counting(int n, int[] nums) {
		if(nums[n] != 0) return nums[n];
		else {
			nums[n] = (counting(n-1, nums) + counting(n-2, nums))%10007;
			return nums[n];
		}
	}
}
