package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2448_별찍기11 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) { 
			printSystem(i, n); 
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void printSystem(int i, int n) {
		if(n == 3) {
			switch(i%3) {
			case 1 : 
				sb.append("  *  ");
				break;
			case 2 :
				sb.append(" * * ");
				break;
			case 0 :
				sb.append("*****");
				break;
			}
			return;
		}
		
		int halfn = n/2;
		if(i <= n/2) {
			printprefix(n);
			printSystem(i, halfn);
			printprefix(n);
		}
		else {
			// 앞쪽 별.
			printSystem(i-halfn, halfn);
			sb.append(" ");
			printSystem(i-halfn, halfn);
		}
	}
	public static void printprefix(int c) {
		int cc = c/2;
		for(int i = 0; i < cc; i++) sb.append(" ");
	}
}
