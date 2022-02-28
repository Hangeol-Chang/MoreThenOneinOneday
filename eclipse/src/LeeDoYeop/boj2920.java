package LeeDoYeop;
import java.util.Scanner;

public class boj2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		String str = "";
		for(int i = 0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i<7; i++) {
			if(arr[i] == arr[i+1]-1) {
				str = "ascending";
			} else if(arr[i] == arr[i+1]+1) {
				str = "descending";
			} else {
				str = "mixed";
				break;
			}
		}
		System.out.println(str);
		sc.close();
			
	}
}
