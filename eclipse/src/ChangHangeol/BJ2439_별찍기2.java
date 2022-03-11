package ChangHangeol;

import java.util.Scanner;

public class BJ2439_별찍기2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = i; j < n; j++) System.out.print(" ");
			for(int j = 0; j < i; j++) System.out.print("*");
			System.out.println();
		}
		in.close();
	}
}
