

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ2407_조합 {
	static BigInteger[][] com;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		com = new BigInteger[n+1][m+1];
		
		//이거 무조건 정수임.
		System.out.println(combi(n, m));
	}
	public static BigInteger combi(int n, int m){
		if(m == 1) return BigInteger.valueOf(n);
		else if(n == m) return BigInteger.valueOf(1);
		else {
			if(com[n][m] == null) {
				com[n][m] = combi(n-1, m-1).add(combi(n-1, m));
//				System.out.println(n + " " + m + " " + com[n][m]);
			}
			return com[n][m];
		}
	}
}