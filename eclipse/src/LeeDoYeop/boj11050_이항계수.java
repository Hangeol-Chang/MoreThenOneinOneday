package LeeDoYeop;
import java.util.Scanner;

public class boj11050_이항계수 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sumN = 1;
		int sumK = 1;
		for(int i = 0; i<K; i++) {
			sumN *= N-i;
		}
		for(int i = K; i>0; i--) {
			sumK *= i;
		}
		System.out.println(sumN/sumK);
	}
}
