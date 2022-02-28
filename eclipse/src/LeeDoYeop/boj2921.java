package LeeDoYeop;
import java.util.Scanner;

public class boj2921 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int sum1 = 0;
	int sum2 = 0;
	for(int i = 0; i<N+1; i++) {
		for(int j = 0; j<N+1; j++) {
			if(i != j) {
				sum1 += i+j;
			}
			else
				sum2 += i+j;
		}
	}
	sum1 = sum1/2;
	System.out.println(sum1+sum2);
}
}
