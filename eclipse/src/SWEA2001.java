import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA2001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			int m = in.nextInt();
			in.nextLine();
			
			//입력받기
			int[][] board = new int[n][];
			for(int i = 0 ; i < n; i++) 
				board[i] = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//입력받기 끝.
			
			int max = 0;
			//전체 배열을 순회하면서
			for(int i = 0; i < n-m+1; i++) {
				for(int j = 0; j < n-m+1; j++) {
					
					int tmp = 0;
					//m범위에 해당하는거 다 더해보기.
					for(int y = 0; y < m; y++){
						for(int x = 0; x < m; x++) {
							tmp += board[i + y][j + x];
						}
					}
					if(max < tmp) max = tmp;
				}
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}
