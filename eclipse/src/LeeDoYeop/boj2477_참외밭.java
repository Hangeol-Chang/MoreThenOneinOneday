package LeeDoYeop;
import java.util.Scanner;

public class boj2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[][] arr = new int[6][2];
		int wIdx = -1;
		int hIdx = -1;
		int maxW = 0;
		int maxH = 0;
		int minusW = 0;
		int minusH = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++)
				arr[i][j] = sc.nextInt();
		}
		
		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (maxW < arr[i][1]) {
					maxW = arr[i][1];
					wIdx = i;
				}

			} else if (maxH < arr[i][1]) {
				maxH = arr[i][1];
				hIdx = i;
			}
		}
		
		if (wIdx == 0) {
			if ((arr[5][0] == 3 || arr[5][0] == 4) && hIdx != 5)
				minusH = maxH - arr[5][1];
			else if ((arr[1][0] == 3 || arr[1][0] == 4) && hIdx != 1)
				minusH = maxH - arr[1][1];
		} else if (wIdx == 5) {
			if ((arr[4][0] == 3 || arr[4][0] == 4) && hIdx != 4)
				minusH = maxH - arr[4][1];
			else if ((arr[0][0] == 3 || arr[0][0] == 4) && hIdx != 0)
				minusH = maxH - arr[0][1];
		} else {
			if ((arr[wIdx + 1][0] == 3 || arr[wIdx + 1][0] == 4) && hIdx != wIdx + 1)
				minusH = maxH - arr[wIdx + 1][1];
			else if ((arr[wIdx - 1][0] == 3 || arr[wIdx - 1][0] == 4) && hIdx != wIdx - 1)
				minusH = maxH - arr[wIdx - 1][1];
		}

		if (hIdx == 0) {
			if ((arr[5][0] == 1 || arr[5][0] == 2) && wIdx != 5)
				minusW = maxW - arr[5][1];
			else if ((arr[1][0] == 1 || arr[1][0] == 2) && wIdx != 1)
				minusW = maxW - arr[1][1];
		} else if (hIdx == 5) {
			if ((arr[4][0] == 1 || arr[4][0] == 2) && wIdx != 4)
				minusW = maxW - arr[4][1];
			else if ((arr[0][0] == 1 || arr[0][0] == 2) && wIdx != 0)
				minusW = maxW - arr[0][1];
		} else {
			if ((arr[hIdx + 1][0] == 1 || arr[hIdx + 1][0] == 2) && wIdx != hIdx + 1)
				minusW = maxW - arr[hIdx + 1][1];
			else if ((arr[hIdx - 1][0] == 1 || arr[hIdx - 1][0] == 2) && wIdx != hIdx - 1)
				minusW = maxW - arr[hIdx - 1][1];
		}
		
		int ans = 0;
		ans = ((maxW * maxH) - (minusW * minusH)) * K;
		System.out.println(ans);
	}
}
