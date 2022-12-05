

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 시간 초과
// 자릿수로 계산.
public class BJ1629_곱셈 {
	static long a;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		a = Integer.parseInt(st.nextToken());
		//곱해야 할 횟수
		int b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		br.close();
		a %= c;
		
		System.out.println(powerset(b)%c);
	}
	public static long powerset(int b) {
		if(b == 1) return a;

		long x = powerset(b/2);
		if(b % 2 == 0) return (x*x)%c;
		else		   return (x*x%c)*a%c;
	}
}
