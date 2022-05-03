package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5525_IOIOI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		
		String arr = br.readLine();
		
		// N이 2N+1부터 세기 시작
		int ans = 0;
		int conti = 0;
		char idf = 'O';
		for(int i = 0; i < len; i++) {
			char idfnow = arr.charAt(i);
			if(idf != idfnow) conti++;
			else {
				if(idfnow == 'O') conti = 0;
				else 			  conti = 1;
			}
			idf = idfnow;
			
			if (conti >= 2*N+1 && conti%2 != 0) ans++;
		}
		System.out.println(ans);
	}
}
