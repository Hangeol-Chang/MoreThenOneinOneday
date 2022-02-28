package LeeDoYeop;
import java.util.Arrays;
import java.util.Scanner;

public class boj4153_직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			Arrays.sort(arr);
			if (a == 0 && b == 0 && c == 0)
				break;
			if ((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
