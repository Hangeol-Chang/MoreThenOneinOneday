

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1541_잃어버린괄호2 {
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
//		System.out.println();
//		for(int i = 0; i < idfs.size(); i++)
//			System.out.print(nums.get(i) + "" + idfs.get(i));
//		System.out.print(nums.get(nums.size()-1));
//		System.out.println();		
//		
		// + 다 처리
		for(int i = 0; i < idfs.size(); i++) {
			char now = idfs.get(i);
			if(now == '+') {
				nums.add(i, nums.remove(i) + nums.remove(i));
				idfs.remove(i);
				i--;
			}
		}
		while(idfs.size() > 0) {
			char now = idfs.remove(0);
			nums.add(0, nums.remove(0) - nums.remove(0));
		}
		
		System.out.println(nums.get(0));
	}
}

/*

10-20+30+40+2-10-50-70+20

1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-11
*/