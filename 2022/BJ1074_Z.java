

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int num = 0;
		while( r != 0 || c != 0) {
			int m = Math.max(r, c)+1;
			int par = 2;
			while(par < m) par *= 2;
			//System.out.println(par + " " + num + ", r, c, : " + r + " " + c);
			
			int p = par*par;
			par /= 2;			
			if(r+1 <= par && c+1 > par) {
				//System.out.println("2사분면");
				//2사분면
				c -= par;
				num += p/4;
			}
			else if(r+1 > par && c+1 <= par) {
				//System.out.println("3사분면");
				//3사분면
				r -= par;
				num += p/4 * 2;
			}else {
				//System.out.println("4사분면");
				//4사분면
				r -= par;
				c -= par;
				num += p/4 * 3;
			}
		}
		System.out.println(num);
	}
}
