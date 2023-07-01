import java.util.Scanner;

public class SWEA13707_secret2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int n = in.nextInt();
			in.nextLine();
			
			int[][] town = new int[n][n];
			int count = 0;
			//X > 0
			//H > 1
			//기지국들 234;
			String giziguks = "XHABC";
			//마을 입력받기
			
			for(int i = 0; i < n; i++) {
				//스트링으로 한 줄씩 부름.
				String Strtmp = in.nextLine();
				//한 줄의 한 자리씩 가져와서, 이를 giziguks에서 찾아서 인덱스값으로 저장.
				for(int j = 0; j < n; j++) {
					town[i][j] = giziguks.indexOf(Strtmp.charAt(j));
					if(town[i][j] == 1) count++;
				}
			}
			
			//델타
			int[] dr = {-1,1,0,0};
			int[] dc = {0,0,-1,1};

			//다 뒤지면서, 기지국 가로, 세로축 H를 0으로 만들어버림
			//하면서 마을 수도 빼버림.
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					
					//-1, 0은 집이랑, 아무것도 없는 곳.
					//2 이상이 기지국
					int giziguk = town[i][j] - 1;
					if(giziguk >= 1) {
						//동서남북 반복
						for(int d = 0; d < 4; d++) {

							//한계까지 돌면서 H를 A로 바꿈.
							for(int num = 1; num <= giziguk ; num++) {
								int nr = i + dr[d]*num;
								int nc = j + dc[d]*num;
								
								if(nr >= 0 && nr < n && 
								   nc >= 0 && nc < n &&
								   town[nr][nc] == 1) {
									
										town[nr][nc] = 0;
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
		in.close();
	}
}
