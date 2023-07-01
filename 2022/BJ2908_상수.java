

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2908_상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[2];
		StringBuilder sb;
		for(int i = 0; i < 2; i++) {
			sb = new StringBuilder();
			sb.append(st.nextToken()).reverse();
			
			a[i] = Integer.parseInt(sb.toString());
		}
		
		System.out.println(a[0]>a[1] ? a[0] : a[1]);
	}
}
