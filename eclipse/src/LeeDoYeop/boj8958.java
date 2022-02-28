package LeeDoYeop;
import java.util.Scanner;

public class boj8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		int sum = 0;
		for (int i = 0; i < t; i++) {
			int count = 0;
			sum = 0;
			String str = sc.nextLine();
			
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 79) {
					count++;
					sum += count;
				} else {
					count = 0;
				}
			}
			
			System.out.println(sum);	
		}
	}
}
