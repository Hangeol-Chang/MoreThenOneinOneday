
import java.util.Scanner;

public class SWEA7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			int[] freq = new int[n+m+1];
			for(int card1 = 1; card1 <= n; card1++) {
				for(int card2 = 1; card2 <= m; card2++) {
					freq[card1 + card2]++;
				}
			}
			int maxcount=0;
			for(int i = 2; i < n+m+1; i++) { if(freq[i] > maxcount) maxcount = freq[i]; }
			
			sb.append("#" + t + " ");
			for(int i = 2; i < n+m+1; i++) {
				if(maxcount == freq[i]) {
					sb.append(i + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		in.close();
	}
}
