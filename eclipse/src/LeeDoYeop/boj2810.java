package LeeDoYeop;
import java.util.Scanner;

public class boj2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seat = sc.next();
		int count = 2;
		for(int i = 0; i< seat.length(); i++) {
			if(seat.charAt(i) == 'L')
				count++;
		}
		count = count/2;
		for(int i = 0; i< seat.length(); i++) { 
			if(seat.charAt(i) == 'S')
				count++;
		}
		if(count>=seat.length())
			count = seat.length();
		System.out.println(count);
	}
}
