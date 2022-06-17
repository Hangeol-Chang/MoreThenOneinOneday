

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6064_카잉달력 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		test: for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 유클리드 호제법 이용 최소공배수 계산.
			int GCD = getgcd(N, M);
			int finalyear = N*M/GCD;
			
			// gcd를 넘어가면 멸망
			while(x <= finalyear && y <= finalyear) {
				if(x == y) {
					sb.append(x + "\n");
					continue test;
				}
				else {
					if(x < y) x += N;
					else	  y += M;
				}
			}
			
			sb.append("-1\n");
		}
		System.out.println(sb);
	}

	private static int getgcd(int x, int y) {
		if(x % y == 0) return y;
		return getgcd(y, x%y);
	}
}