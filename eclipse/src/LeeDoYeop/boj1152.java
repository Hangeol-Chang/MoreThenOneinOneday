package LeeDoYeop;
import java.util.Scanner;

public class boj1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.trim();
		int count = 1;
		int c;
		for (int i = 0; i < str.length(); i++) {
//			c = str.charAt(i); 
			if (str.charAt(i) == 32)
				count++;
		}
		if (str.isEmpty()) {
			System.out.println(0);
		} else 
			System.out.println(count);
	}
}
