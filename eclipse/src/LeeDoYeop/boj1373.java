package LeeDoYeop;
import java.util.Scanner;

public class boj1373 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		if (num.length() % 3 == 0) {
			int[] arr = new int[num.length() / 3];
			for (int i = 0; i < num.length(); i++) {
				if (i % 3 == 0) {
					if (num.charAt(i) == '1')
						arr[i / 3] += 4;
				} else if (i % 3 == 1) {
					if (num.charAt(i) == '1')
						arr[i / 3] += 2;
				} else {
					if (num.charAt(i) == '1')
						arr[i / 3] += 1;
				}
			}
			for (int i = 0; i < num.length()/3; i++)
				System.out.print(arr[i]);
		} else if (num.length() % 3 == 1) {
			int[] arr = new int[((num.length() / 3) + 1)];
			for (int i = 0; i < num.length(); i++) {
				if (i == 0) {
					if (num.charAt(i) == '1')
						arr[i / 3] += 1;
				} else {
					if (i % 3 == 0) {
						if (num.charAt(i) == '1')
							arr[i / 3] += 1;
					} else if (i % 3 == 1) {
						if (num.charAt(i) == '1')
							arr[(i / 3) + 1] += 4;
					} else {
						if (num.charAt(i) == '1')
							arr[(i / 3) + 1] += 2;
					}
				}
			}
			for (int i = 0; i < num.length()/3+1; i++)
				System.out.print(arr[i]);
		} else if (num.length() % 3 == 2) {
			int[] arr = new int[((num.length() / 3) + 1)];
			for (int i = 0; i < num.length(); i++) {
				if (i == 0) {
					if (num.charAt(i) == '1')
						arr[i / 3] += 2;
				} else if (i == 1) {
					if (num.charAt(i) == '1')
						arr[i / 3] += 1;
				} else {
					if (i % 3 == 0) {
						if (num.charAt(i) == '1')
							arr[i / 3] += 2;
					} else if (i % 3 == 1) {
						if (num.charAt(i) == '1')
							arr[(i / 3)] += 1;
					} else {
						if (num.charAt(i) == '1')
							arr[(i / 3) + 1] += 4;
					}
				}
			}
			for (int i = 0; i < num.length()/3+1; i++)
				System.out.print(arr[i]);
		}
	}
}
