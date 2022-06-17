

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10989_수정렬하기4 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10001];
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[Short.parseShort(br.readLine())]++;
		}
		br.close();
		
		StringBuilder sb = new StringBuilder();
		short idx = 1;
		while(N > 0) {
			while(nums[idx] > 0) {
				sb.append(idx + "\n");
				nums[idx]--;
				N--;
			}
			idx++;
			System.out.print(sb);
			sb.setLength(0);
		}
		
//		for(int i = 1; i < 10001; i++) {
//			while(nums[i] > 0) {
//				sb.append(i + "\n");
//				nums[i]--;
//			}
//		}
//		System.out.println(sb);
	}
}
