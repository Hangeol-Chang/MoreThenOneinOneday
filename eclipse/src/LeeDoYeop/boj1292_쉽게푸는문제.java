package LeeDoYeop;
import java.util.Scanner;

public class boj1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[99999];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int idx =0;
		int sum =0;
		for (int i = 1; i <= 1000; i++) {
			for(int j =0; j<i; j++) {
				idx++;
				arr[idx] = i;
				if(idx<=b && idx>=a)
					sum+=arr[idx];
				if(idx>b)
					break;
			}
		}
		System.out.println(sum);
	}
}
