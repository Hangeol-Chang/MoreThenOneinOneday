package ChangHangeol;
import java.util.Scanner;

/**
 * 카드를 겹치지 않게 뽑으면서,
 * 최대치
 */
public class BJ제1회블롭컵_blobblush {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		
		long zisu = 1;
		while(n / (1<<zisu) > 0) {
			zisu++;
		}

		long xord = ((1<<zisu) - 1) ^ n;
		if(xord == 0) System.out.printf("%d\n%d", 1, n);
		else System.out.printf("%d\n%d\n%d", 2, xord, n);
		in.close();
	}
}
