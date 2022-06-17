
import java.util.Scanner;

/**
 * 1부터 자기보다 큰 수랑 곱한것만 남기면 됨.
 *  
 *  */
public class BJ8320_직사각형을만드는방법 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int count = 0;
		for(int i = 1; i < n/2 + 2; i++ ) {
			int j = i;
			while(j*i <= n) {
				count++;
				j++;
			}
		}
		System.out.println(count);
		in.close();
	}
}
