package LeeDoYeop;
import java.util.Arrays;
import java.util.Scanner;

public class boj1337_올바른배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int ans = 0;
		int ansMin = 8;
		for (int i = 0; i < N; i++) {
			int a = arr[i];
			int cnt = 1;
			for (int j = 1; j < 5; j++) {
				for (int k = 1; k < 5; k++) {
					if (i + k < N) {
						if (a + j == arr[i + k])
							cnt++;
					}
				}
			}
			if (cnt >= 5) {
				ansMin = 0;
			} else {
				ans = 5 - cnt;
				if (ansMin > ans)
					ansMin = ans;
			}
		}
		System.out.println(ansMin);
	}
}
