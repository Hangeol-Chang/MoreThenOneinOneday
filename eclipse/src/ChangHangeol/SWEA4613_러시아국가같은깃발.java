import java.util.Scanner;

public class SWEA4613_러시아국가같은깃발 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int n = in.nextInt();
			int m = in.nextInt();
			in.nextLine();
			//각 줄의 WBR 양을 저장할거임.
			String ref = "WBR";
			int[][] count = new int[n][3];
			//WBR로 바꾸는데 필요한 수를 저장.
			int[][] need = new int[n][3];
			for(int i = 0; i < n; i++) {
				String tmp = in.nextLine();
				for(int j = 0; j < m; j++)
					count[i][ref.indexOf(tmp.charAt(j))]++;
				
				need[i][0] = count[i][1] + count[i][2];
				need[i][1] = count[i][2] + count[i][0];
				need[i][2] = count[i][0] + count[i][1];
//				System.out.println(count[i][0] + " " + count[i][1] + " " + count[i][2]);
//				System.out.println(need[i][0] + " " + need[i][1] + " " + need[i][2]);
			}
			//입력받기 끝.
			
			//부분집합 문제.
			int min = 2500;
			int i = 0;
			while(i < n-2) {
				//0~i 까지는 하얀색으로 칠하고
				//i+1 ~ j까지는 파란색으로
				//j+1 ~ n-1까지는 빨간색.
				int sum = 0;
				for(int w = 0; w <= i; w++) sum += need[w][0];
				
				int j = i+1;
				while(j < n-1) {
					int sum2 = sum;
					for(int b = i+1; b <= j; b++) sum2 += need[b][1];
					for(int r = j+1; r <  n; r++) sum2 += need[r][2];
					//여기까지 오면 다 더한거.
					
					min = Math.min(min,  sum2);
					j++;
				}
				i++;
			}
			sb.append(min + "\n");
		}
		System.out.println(sb);
		in.close();
	}
}
