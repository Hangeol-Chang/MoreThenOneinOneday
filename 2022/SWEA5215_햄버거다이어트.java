
import java.util.Scanner;

public class SWEA5215_햄버거다이어트 {
	public static int N, L;
	public static int[] score, calorie;
	public static int ans;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			N = in.nextInt();
			L = in.nextInt();
			ans = 0;
			score = new int[N];
			calorie = new int[N];
			
			for(int i = 0; i < N; i++) {
				score[i] = in.nextInt();
				calorie[i] = in.nextInt();
			}
			//비트연산을 이용한 PowerSet 구현.
			
			
			for( int i = 0; i < 1<<N; i++) {
				int sumScore = 0;
				int sumCal = 0;
				
				for(int j = 0; j < N; j++) {
					if((i & (1<<j)) > 0) {
						sumScore += score[j];
						sumCal += calorie[j];
					}
				}
				
				if(sumCal <= L) {
					ans = Math.max(ans,  sumScore);
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
