import java.util.Scanner;

public class SWEA13707_secret {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int n = in.nextInt();
			in.nextLine();
			
			char[][] town = new char[n][n];
			int count = 0;
			
			//마을 입력받기
			for(int i = 0; i < n; i++) {
				//토큰으로 문자열 찟어서 가져옴.
				String Strtmp = in.nextLine();
				for(int j = 0; j < n; j++) {
					char tmp = Strtmp.charAt(j);
					town[i][j] = tmp;
					if(tmp == 'H') count++;
				}
			}

			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};
			String giziguks = "ZABC";
			
			//다 뒤지면서, 기지국 가로, 세로축 H를 0으로 만들어버림
			//하면서 마을 수도 빼버림.
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					char giziguk = town[i][j];
					if(giziguk != 'X' && giziguk != 'H') {
						int limit = giziguks.indexOf(giziguk);
						
						for(int d = 0; d < 4; d++) {
							for(int num = 1; num <= limit ; num++) {
								int nr = i + dr[d]*num;
								int nc = j + dc[d]*num;
								
								if(nr >= 0 && nr < n && 
								   nc >= 0 && nc < n &&
								   town[nr][nc] == 'H') {
									
										town[nr][nc] = 'X';
										count--;
								}
							}
						}
					}
				}
			}
			sb.append(count + "\n");
			
		}
		System.out.println(sb);
	}
}
