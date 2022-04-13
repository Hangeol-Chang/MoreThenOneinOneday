package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stk = new Stack<>();
		for(int i = 0; i < N; i++) {
			int m = Integer.parseInt(br.readLine());
			switch (m) {
			case 0 :
				stk.pop();
				break;
			default :
				stk.add(m);
			}
		}
		int ans = 0;
		while(!stk.isEmpty()) ans += stk.pop();
		System.out.print(ans);
	}
}
