

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
public class BJ11444_피보나치수6 {
	static long[][] F = {{1, 1}, {1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		
		powering(num-1);
		System.out.println(F[0][0]%1000000007);
	}
	public static void powering(long n) {
		if(n == 0 || n == 1) return;
		
		powering(n/2);
		crossing();
		if(n%2 != 0) odd();
	}
	public static void crossing() {
		long a00 = F[0][0] * F[0][0] + F[0][1] * F[1][0];
		long a01 = F[0][0] * F[0][1] + F[0][1] * F[1][1];
		long a10 = F[1][0] * F[0][0] + F[1][1] * F[1][0];
		long a11 = F[1][0] * F[0][1] + F[1][1] * F[1][1];
		
		F[0][0] = a00%1000000007;
		F[0][1] = a01%1000000007;
		F[1][0] = a10%1000000007;
		F[1][1] = a11%1000000007;
	}
	public static void odd() {
		long a00 = F[0][0] + F[0][1];
		long a01 = F[0][0];
		long a10 = F[1][0] + F[1][1];
		long a11 = F[1][0];

		F[0][0] = a00%1000000007;
		F[0][1] = a01%1000000007;
		F[1][0] = a10%1000000007;
		F[1][1] = a11%1000000007;
	}
}

/*

1 1 2 3 5 8 13 21 

*/