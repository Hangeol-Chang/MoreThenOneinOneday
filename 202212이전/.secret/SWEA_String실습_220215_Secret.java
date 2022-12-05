//ij 두 거리 중 더 먼 것 * 감소량
import java.util.Scanner;

public class SWEA_String실습_220215_Secret {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			int m = in.nextInt();
			int r = in.nextInt() - 1;
			int c = in.nextInt() - 1;
			int d = in.nextInt();
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				int coni = Math.abs(i-r);
				for(int j = 0; j < n; j++) {
					// i-c와 j-r 중 더 큰 값.
					//coni는 동일하기 때문에, 연산량 줄이기 위해서 위에서 계산해서 가져옴.
					int conj = Math.abs(j-c);
					int p = m + d*Math.max(coni, conj);
					if(p<0) p = 0;
					else if(p>255) p = 255;
					
					sum += p;
				}
				sb.append(sum + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
