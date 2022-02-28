package LeeDoYeop;

import java.util.Scanner;

public class boj13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] male = new int[6];
		int[] female = new int[6];
		for (int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			if(gender == 1)
				male[sc.nextInt()-1]++;
			else
				female[sc.nextInt()-1]++;
		}
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			if(male[i]%K == 0)
				cnt += male[i]/K;
			else
				cnt +=  male[i]/K+1;
			if(female[i]%K == 0)
				cnt += female[i]/K;
			else
				cnt += female[i]/K +1;
		}
		System.out.println(cnt);
	}
}

