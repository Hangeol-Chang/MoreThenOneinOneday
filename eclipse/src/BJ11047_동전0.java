import java.util.Scanner;
import java.util.Stack;

public class BJ11047_동전0 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Integer> var = new Stack<>();
		
		int n = in.nextInt();
		int pay = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			var.add(in.nextInt());
		}
		
		int count = 0;
		while(pay > 0) {
			int coin = var.pop();
			count += pay/coin;
			pay %= coin;
		}
		System.out.println(count);
	}
}

/*
10 4791
1
5
10
50
100
500
1000
5000
10000
50000
*/