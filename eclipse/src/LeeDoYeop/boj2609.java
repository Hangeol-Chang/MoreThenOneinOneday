package LeeDoYeop;
import java.util.Scanner;

public class boj2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int max = 0;
		int min = 0;
		if(a > b) {
			for( int i = b ; i > 0; i--) {
				if(a % i == 0 && b % i == 0) {
					max = i;
					break;
				}
			}
			for ( int i = b; i <= a*b; i++) {
				if(i % a == 0 && i % b == 0) {
					min = i;
					break;
				}
			}
		}else {
			for( int i = a ; i > 0; i--) {
				if(a % i == 0 && b % i == 0) {
					max = i;
					break;
				}
			}
			for ( int i = a; i <= a*b; i++) {
				if(i % a == 0 && i % b == 0) {
					min = i;
					break;
		}
	}
}
		System.out.println(max);
		System.out.println(min);
	}
}
