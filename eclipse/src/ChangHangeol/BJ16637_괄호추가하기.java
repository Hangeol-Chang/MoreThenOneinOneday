package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ16637_괄호추가하기 {
	static long ans;
	static ArrayList<Long> nums = new ArrayList<>();
	static ArrayList<Character> idfs = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 입력받기.
		String ini = br.readLine();
		for(int i = 0; i < N; i++) {
			if(i%2 == 0) nums.add((long) (ini.charAt(i) - '0'));
			else		 idfs.add(ini.charAt(i));
		}
		
		ans = 0;
		calc();
		System.out.println(ans);
	}
	public static void calc() {
		// 0번에 대해 0, 1계산, 1번에 대해 1, 2계산, 2번에 대해 2, 3 계산.
		if(idfs.size() == 0) {
			ans = Math.max(ans, nums.get(0));
			return;
		}
		for(int i = 0; i < idfs.size(); i++) {
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
			
			// 재귀 실행.
			calc();
			
			// 배열 원상복구
			nums.remove(i);
			nums.add(i, num2);
			nums.add(i, num1);
			idfs.add(i, idf);
		}
	}
}
