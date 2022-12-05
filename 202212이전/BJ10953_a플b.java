
import java.util.Scanner;
import java.util.stream.Stream;

public class BJ10953_a플b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for(int t = 1; t <= T; t++) {
			int[] num = Stream.of(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
			System.out.println(num[0] + num[1]);
		}
		in.close();
	}
}
