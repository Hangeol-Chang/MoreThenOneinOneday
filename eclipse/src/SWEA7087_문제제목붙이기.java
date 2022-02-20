import java.util.Scanner;

public class SWEA7087_문제제목붙이기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			boolean[] count = new boolean[27];
			for(int i = 0; i < n; i++) {
				char upper = in.next().charAt(0);
				
				count[upper - 'A'] = true;
			}
			int idx = 0;
			while(count[idx]) {
				idx++;
			}
			sb.append(idx + "\n");
		}
		System.out.println(sb);
	}
}
