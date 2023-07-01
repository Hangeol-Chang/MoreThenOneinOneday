

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ16637_괄호추가하기 {
	static long ans;
	static int N;
	static ArrayList<Integer> sel = new ArrayList<>();
	static ArrayList<Character> idfs = new ArrayList<>();
	static ArrayList<Long> nums = new ArrayList<>();
	static String ini;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 입력받기.
		ini = br.readLine();
		for(int i = 0; i < N; i++) {
			if(i%2 == 0) nums.add((long) (ini.charAt(i) - '0'));
			else		 idfs.add(ini.charAt(i));
		}
		
		
		ans = Integer.MIN_VALUE;
		calc(0);
		System.out.println(ans);
	}
	public static void calc(int idx) {
		if(idx >= idfs.size()) {
			// 남은거 계산.
			calc2();
			return;
		}
		// 괄호에 들어갈거 먼저 다 계산.
		for(int i = idx; i < idfs.size(); i++) {
			// 이후로 바꾸기 전에 한번 돌리기.
			calc2();
			
			long num2 = nums.remove(i+1);
			long num1 = nums.remove(i);

			char idf = idfs.remove(i);
			long num = 0;
			switch(idf) {
			case '+' :
				num = num1 + num2;
				break;
			case '-' :
				num = num1 - num2;
				break;
			case '*' :
				num = num1 * num2;
			}
			nums.add(i, num);

//			System.out.println(i);
//			System.out.println(nums);
//			System.out.println(idfs);
			// 재귀 실행.
			calc(i+1);

			// 원상복구
			nums.remove(i);
			nums.add(i, num2);
			nums.add(i, num1);
			idfs.add(i, idf);
		}
	}
	public static void calc2() {
		long num1 = nums.get(0);
		for(int i = 0; i < idfs.size(); i++) {
			char idf = idfs.get(i);
			switch(idf) {
			case '+' :
				num1 += nums.get(i+1);
				break;
			case '-' :
				num1 -= nums.get(i+1);
				break;
			case '*' :
				num1 *= nums.get(i+1);
			}
//			System.out.println("계산중 : " + num1);
		}
		ans = Math.max(ans, num1);
//		System.out.println(num1);
	}
}

/*

19
1*2+3*4*5-6*7*8*9*0

17
2*6+2-8-6+1*2-9*3

17
9*1-9*1-9*1-9*1-9

*/