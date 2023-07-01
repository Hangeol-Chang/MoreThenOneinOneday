
import java.util.Scanner;

public class BJ제1회블롭컵_blobfearful {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long K = in.nextLong();
		int Q = in.nextInt();
		
		for(int t = 0; t < Q; t++) {
			long a = in.nextLong();
			long tnum = K;
			if(tnum % a == 0) tnum /= a;
			
			int i = 2;
			while(fact(i) % tnum != 0) {
				i++;
			}
			
			sb.append(i);
			if(t != Q-1) sb.append(" ");
		}
		System.out.print(sb);
		in.close();
	}
	
	static long fact(int n) {
		if(n == 1 || n == 0) return 1;
		else return n * fact(n-1);
	}
}

/*
2147483647

1073741823
*/