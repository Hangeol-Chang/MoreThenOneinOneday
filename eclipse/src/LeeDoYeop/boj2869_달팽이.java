package LeeDoYeop;
import java.util.Scanner;

public class boj2869_달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int ans = 1;
		
		if(A>= V)
			System.out.println(ans);
		else {
			V -= A;
			int AB = A-B;
			ans = V/ AB;
			if( V % AB == 0) 
				System.out.println(ans+1);
			else
				System.out.println(ans+2);
		}
	}
}
