

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ구데기컵2_2_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		sb.append(0);
		for(int i = 1; i <= N; i++) {
			StringBuilder ssb = new StringBuilder();
			int num = i;

			while(num > 0) {
				ssb.append( num%2 );
				num /= 2;
			}
			ssb.reverse();
			sb.append(ssb);
		}
		System.out.println(sb);
	}
}

/*

2로 나눠가면서,나머지만

*/