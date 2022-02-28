package ChangHangeol;
import java.util.Scanner;

/**
 * 100 62 38 24 14 10 4 6
 * 100 50 50 0
 * 100 60 40 20 20 0 20
 * 100 70 30 40 
 * 100 66 34 17 17 0
 * 100 75 25 50 < 이렇게 튀어오르면 안됨.
 * 100 68 34 34 0
 * 100 69 31 38
 * 1/2 n 과 3/4 n 사이
 */

public class BJ2635_수이어가기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		int a = 0;

		int savea = 0;
		int saveb = 0;
		int maxcount = 0;
		
		int startc = n/2 + 1;
		while(startc <= 3*n/4 + 1) {
			int b = n;
			int c = startc++;
			int count = 1;
			while(c >= 0) {
				a = b;
				b = c;
				count++;
				c = a - b;
				//System.out.println("a : " + a + ", b : " + b + ", c : " + c + ", count : " + count);
			}
			if(maxcount < count) {
				savea = a;
				saveb = b;
				maxcount = count;
			}
			b++;
		}
		
		int[] nums = new int[maxcount];
		nums[maxcount-1] = saveb;
		nums[maxcount-2] = savea;
		for(int i = maxcount-3; i >= 0; i--) nums[i] = nums[i+1] + nums[i+2];
		System.out.println(maxcount);
		for(int i = 0; i < maxcount; i++) System.out.print(nums[i] + " ");
	}
}
