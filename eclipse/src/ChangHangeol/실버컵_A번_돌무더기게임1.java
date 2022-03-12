package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/*
 * 0이 두개가 되는 순간 끝.
 * 제일 작은 수부터 꺼내서, 제일 큰 것에 넣어야 함.
 */
public class 실버컵_A번_돌무더기게임1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int count = 0;
			while(playgame(nums)) {
				count++;
			}
			sb.append(((count%2 == 0) ? "R" : "B" ) + "\n");
		}
		System.out.println(sb);
	}
	public static boolean playgame(int[] nums) {
		Arrays.sort(nums);
		boolean[] pick = new boolean[3];
		
		int pickcount = 0;
		for(int i = 0; i < 3; i++) {
			if(nums[i] != 0) {
				nums[i]--;
				pick[i] = true;
				if(++pickcount == 2) break;
			}
		}
		if(pickcount == 2) {
			for(int i = 0; i < 3; i++) {
				if(pick[i] == false) {
					nums[i]++;
					return true;
				}
			}
		}
		return false;
	}
}
