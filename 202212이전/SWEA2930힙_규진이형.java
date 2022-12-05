

import java.util.Arrays;
import java.util.Scanner;

import javax.xml.namespace.QName;

public class SWEA2930힙_규진이형 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			int size = 0;
			int[] ans = new int[N];
			int idx = 0;
			
			for (int i = 0; i < N; i++) {
				int n1 = sc.nextInt();
				if (n1 == 1) {
					arr[++size] = sc.nextInt();
					int calSize = size;
					while (calSize / 2 >= 1) {
						if (arr[calSize] > arr[calSize / 2]) {
							int tmp = arr[calSize];
							arr[calSize] = arr[calSize / 2];
							arr[calSize / 2] = tmp;
							calSize/=2;
						} else
							break;
					}
//					System.out.println(Arrays.toString(arr));
				} else {
					if (size >0) {
						ans[idx++] = arr[1];
						arr[1] = arr[size--];
						//arr[size+1] =0;
						int rootIdx = 1;
						int left = rootIdx * 2;
						int right = rootIdx * 2 + 1;
						if(left > size) {
						left = 0;
						}
						if(right > size) {
							right = 0;
					}
							
						while ( arr[left] > arr[rootIdx] || arr[right] > arr[rootIdx]) {
							if (arr[left] >= arr[right]) {
								int tmp = arr[left];
								arr[left] = arr[rootIdx];
								arr[rootIdx] = tmp;
								left *= 2;
								right = left + 1;
							} else if (arr[right] > arr[left]) {
								int tmp = arr[right];
								arr[right] = arr[rootIdx];
								arr[rootIdx] = tmp;
								left = right * 2;
								right = left + 1;
							}
							rootIdx = left/2;
						}
					} else {
						
						ans[idx++] = -1;
						
					}

				}
			}
			System.out.printf("#%d", tc);
			for (int i = 0; i < idx; i++) {
				System.out.print(" " + ans[i]);
			}
			System.out.println();
		}
	}
}