package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ16637_괄호추가하기 {
	static long ans;
	static int N;
	static ArrayList<Integer> sel = new ArrayList<>();

	static boolean[] vi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		vi = new boolean[N/2];
		
		// 입력받기.
		String ini = br.readLine();
		
		
		ans = 0;
		select(0);
		System.out.println(ans);
	}
	public static void select(int idx) {
		if(idx == N) {
			calc();
			return;
		}
		for(int i = idx; i < N/2; i++) {
			if(vi[i]) continue;
			// 여기 처리한걸로 해주기.
			vi[i] = true;
			if(i < N/2 -1) vi[i+1] = true;
			
			
			// 원상복구
			vi[i] = false;
			if(i < N/2 -1) vi[i+1] = false;
		}
	}
	
	// 후위연산으로 바꾸면서 진행.
	public static void calc() {
		
	}
}
