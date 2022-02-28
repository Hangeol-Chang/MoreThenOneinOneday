package ChangHangeol;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 세상이 미쳐가지고, 붕어빵도 자격이 있어야 먹는구나.
 * 
 * 손님을 다 입력받아서 오는 시간순서대로 정렬함.
 * 손님이 오면, 그 시간까지 만들어진 붕어빵을 계산하고,
 * 여태까지 팔린 양을 뺌.
 * 팔린 양을 뺏는데 1보다 크면 판매가 가능한거고, 아니면 불가
 */

public class SWEA1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n  = in.nextInt();	//손님 수
			int m = in.nextInt();	//붕어빵 제작 시간.
			int k = in.nextInt();	//한번에 나오는 붕어빵 개수.
			
			//손님 입력 받아서 오는 순서대로 정렬
			int[] sonnim = new int[n];
			for(int i = 0; i < n; i++) sonnim[i] = in.nextInt();
			Arrays.sort(sonnim);
			
			//남은 붕어빵 양을 계산해 올려야 됨.
			boolean yesican = true;
			int maked = 0;
			int sold = 0;
			for(int i = 0; i < n; i++) {
				maked = (sonnim[i]/m)*k - sold;
				if(maked > 0) sold++;
				else {
					yesican = false;
					break;
				}
			}
			sb.append("#" + t + " " + (yesican ? "Possible" : "Impossible") + "\n");;
		}
		System.out.println(sb);
		in.close();
	}
}
