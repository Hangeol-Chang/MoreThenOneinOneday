package LeeDoYeop;
import java.util.Scanner;

public class boj8320_직사각형을만드는방법 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j<= i; j++) {
				if (i % j == 0)
					cnt++;
			}
			if(cnt % 2 == 0)
				sum += cnt/2;
			else
				sum += cnt/2+1;
		}
		System.out.println(sum);
	}
}
