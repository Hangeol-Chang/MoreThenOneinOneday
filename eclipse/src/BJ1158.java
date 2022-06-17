
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1158 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.close();
		LinkedList<Integer> nums = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) nums.add(i);
		
		System.out.print("<" + nums.remove(k-1));
		int idx = k-1;
		int count = 1;
		while(!nums.isEmpty()) {
			if (count %k == 0) {
				//System.out.println(nums);
				idx = idx%nums.size();
				System.out.print(", " + nums.remove(idx));
			}else {
				idx++;
			}
			count++;
		}
		System.out.print(">");
	}
}
