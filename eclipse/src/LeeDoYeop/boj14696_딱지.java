package LeeDoYeop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj14696_딱지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			List<Integer> A = new ArrayList<Integer>();
			List<Integer> B = new ArrayList<Integer>();
			int aC = sc.nextInt();
			for (int i = 0; i < aC; i++)
				A.add(sc.nextInt());
			int bC = sc.nextInt();
			for (int i = 0; i < bC; i++)
				B.add(sc.nextInt());
			Collections.sort(A, Collections.reverseOrder());
			Collections.sort(B, Collections.reverseOrder());
			int len = Math.min(A.size(), B.size());
			char winner = 0;
			for (int i = 0; i < len; i++) {
				if (A.get(i) > B.get(i)) {
					winner = 'A';
					System.out.println(winner);
					break;
				} else if (A.get(i) == B.get(i)) {
					winner = 'D';
					continue;
				} else {
					winner = 'B';
					System.out.println(winner);
					break;
				}
			}
			if (winner == 'D') {
				if (A.size() > B.size())
					System.out.println("A");
				else if (A.size() == B.size())
					System.out.println("D");
				else
					System.out.println("B");
			}
		}
	}
}
