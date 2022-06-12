package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1644_소수의연속합 {
	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		boolean[] a = new boolean[num+2];
		a[1] = true;
		ArrayList<Integer> nums = new ArrayList<>();
		
		// 소수 가져오기.
		int sqnum = (int) Math.sqrt(num);
		for( int i = 2; i <= sqnum; i++) {
			if(a[i]) continue;
			a[i] = true;
			nums.add(i);
			
			int idf = i * i;
			while(idf <= num) {
				a[idf] = true;
				idf += i;
			}
		}
		int ii = sqnum+1;
		while(true) {
			if(!a[ii]) {
				if( ii < num) nums.add(ii);
				if(ii > num/2)
					break;
			}
			ii++;
		}
//		System.out.println(nums);
		
		// 투포인터
		int anscount = 0;
		if(nums.size() > 0) {
			int l = 0;
			int r = 0;
			int sum = nums.get(0);
			while( r < nums.size()-1 ) {
				if(sum < num) 	   sum += nums.get(++r);
				else {
					if (sum == num) anscount++;
					sum -= nums.get(l++);
				}
			}
			
			while(l <= r && sum >= num) {
				if(sum == num) anscount++;
				sum -= nums.get(l++);
			}
		}
		// num이 소수일 때
		if(!a[num]) anscount++;
		System.out.println(anscount);
	}
}
