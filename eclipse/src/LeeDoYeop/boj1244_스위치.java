package LeeDoYeop;
import java.util.Scanner;

public class boj1244_스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt(); // 스위치 개수
		int[] swt = new int[switchNum + 1]; // 인덱스 그대로 활용하기 위해

		for (int i = 1; i <= switchNum; i++) { // 스위치 입력
			swt[i] = sc.nextInt();
		}

		int student = sc.nextInt(); // 학생수 입력

		for (int st = 0; st < student; st++) {
			int gender = sc.nextInt(); // 성별 입력
			int num = sc.nextInt(); // 스위치번호 입력
			if (gender == 1) {// 남자
				for (int i = num; i <= switchNum; i += num) { // 남자일때 배수마다 상태 바꿔주기
					if (swt[i] == 1)
						swt[i] = 0;
					else
						swt[i] = 1;
				}

			} else { // 여자
				// 여자일 때 끝이거나 좌우한칸이 대칭이 아닐 때 본인 하나만 바꾸면 된다.
				if ((num == 1 || num == switchNum) || swt[num - 1] != swt[num + 1]) {
					if (swt[num] == 1)
						swt[num] = 0;
					else
						swt[num] = 1;
				} else { // 본인을 바꿔주고 좌우 대칭 범위를 찾아보기
					if (swt[num] == 1)
						swt[num] = 0;
					else
						swt[num] = 1;
					// 왼쪽은 num-1 ~ 오른쪽은 num+1
					int left = num - 1;
					int right = num + 1;
					// 인덱스 범위를 안 벗어날때까지
					while (left > 0 && right <= switchNum) {
						if (swt[left] == swt[right]) {
							if (swt[left] == 1)
								swt[left] = 0;
							else
								swt[left] = 1;
							if (swt[right] == 1)
								swt[right] = 0;
							else
								swt[right] = 1;
							left--; //쭈우욱 범위 늘려보기
							right++; 
						} else {// 대칭아닐때 탈출
							break;
						}
					}
				}
			}
		}

		for (int i = 1; i <= switchNum; i++) {
			System.out.printf("%d ", swt[i]);
			if (i % 20 == 0)//20줄씩 출력.
				System.out.println();
		}
	}
}
