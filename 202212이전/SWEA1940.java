
import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA1940 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int speed = 0;
			int n = in.nextInt();
			in.nextLine();
			int[] orders = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int distance =  0;
			for(int order : orders) {
				
				
				
				
			}
		}
	}
}
