package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1550_16진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ref = "0123456789ABCDEF";
		String a = br.readLine();
		
		int idx = 0;
		int len = a.length();
		int ans = 0;
		while(idx < len) {
			int num = ref.indexOf(a.charAt(len-1-idx));
			ans += num * (int)Math.pow(16, idx++);
		}
		System.out.println(ans);
	}
}