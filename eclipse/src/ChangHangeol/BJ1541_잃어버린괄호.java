package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 시간 초과
public class BJ1541_잃어버린괄호 {
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> idfs = new ArrayList<>();
	static int minv = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ini = br.readLine();
		// +가 두개 나올 때, 뒤에꺼 계산해 버려도 됨.
		int pointer = 0;
		for(int i = 0; i < ini.length(); i++) {
			char now = ini.charAt(i);
			if(now >= '0' && now <= '9') continue;
			else {
				nums.add(Integer.parseInt(ini.substring(pointer, i)));
				idfs.add(now);
				pointer = i+1;
			}
		}
		nums.add(Integer.parseInt(ini.substring(pointer, ini.length())));

		// 입력 완료.
		
//		for(int i = 0; i < idfs.size(); i++)
//			System.out.print(nums.get(i) + "" + idfs.get(i));
//		System.out.print(nums.get(nums.size()-1));
		
		char ref = '+';
		for(int i = 0; i < idfs.size(); i++) {
			char now = idfs.get(i);
			if(ref == '+' && now == '+') {
				nums.add(i, nums.remove(i) + nums.remove(i));
				idfs.remove(i);
				i--;
			}
			else ref = now;
		}
		// 정리완료.
		System.out.println();
		for(int i = 0; i < idfs.size(); i++)
			System.out.print(nums.get(i) + "" + idfs.get(i));
		System.out.print(nums.get(nums.size()-1));
		System.out.println();		
		
		run();
		System.out.println(minv);
	}
	public static void run() {
		if(nums.size() == 1) {
//			System.out.println("통과 : " + nums.get(0));
			minv = Math.min(minv, nums.get(0));
			return;
		}
		
		for(int i = 0; i < idfs.size(); i++) {
			int num1 = nums.remove(i);
			int num2 = nums.remove(i);
			
			int num = 0;
			char idf = idfs.remove(i);
			switch(idf) {
			case '+' :
				num = num1 + num2;
				break;
			case '-' :
				num = num1 - num2;
				break;
			}
			nums.add(i, num);
			
//			System.out.println();
//			for(int j = 0; j < idfs.size(); j++)
//				System.out.print(nums.get(j) + "" + idfs.get(j));
//			System.out.print(nums.get(nums.size()-1));
//			System.out.println();
			run();
			
			// 원상복귀
			nums.remove(i);
			nums.add(i, num2);
			nums.add(i, num1);
			idfs.add(i, idf);
		}
	}
}

/*

10-20+30+40+2-10-50-70+20

1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-11
*/