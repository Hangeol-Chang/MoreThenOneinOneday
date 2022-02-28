package LeeDoYeop;
import java.util.Scanner;

public class boj2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		int answer = 0;
		for(int i = 1; i<=N; i++) {
			sum = i;
			for(int j = i; j > 0 ; j /= 10){
	            int num = j % 10;
	            sum += num;
			}
			if(sum == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
