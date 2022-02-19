import java.util.Scanner;
/**
 * 1 북 > 0
 * 2 남 > 1
 * 3 서 > 2
 * 4 동 > 3
 */
public class BJ2564_경비원 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] xy = new int[2];
		xy[0] = in.nextInt();
		xy[1] = in.nextInt();
		int n = in.nextInt();
		int[][] shops = new int[n][2];
		
		for(int t = 0; t < n; t++) {
			shops[t][0] = in.nextInt() - 1;
			shops[t][1] = in.nextInt();
		}
		int dongd = in.nextInt() - 1;
		int dongr = in.nextInt();
		
		int distancesum = 0;
		for(int i = 0; i < n; i++) {
			int distance = 0;
			int loc = dongd/2;
			
			if(dongd == shops[i][0]) {
				//같은변에 있으면 이걸로 끝.
				distance += Math.abs(shops[i][1] - dongr);
				
			} else if(loc == shops[i][0]/2) {
				//두 개가 북남, 동서에 있으면,
				//가로지르는 거리
				distance += xy[1 - loc];
				distance += Math.abs(shops[i][1] - dongr);
				distance += 2 * Math.min(Math.min(shops[i][1],  Math.abs(xy[loc]) - shops[i][1]), Math.min(dongr,  Math.abs(xy[loc]) - dongr));
			}else {	
				//두 개가 ㄱ자로 있을 때,
				distance += (shops[i][0]%2)*(xy[1-shops[i][0]/2]-dongr) + (1-shops[i][0]%2)*(dongr);
				distance +=(dongd%2)*(xy[1-dongd/2]-shops[i][1]) + (1-dongd%2)*(shops[i][1]);
				
//				System.out.println((shops[i][0]%2)*(xy[1-shops[i][0]/2]-dongr) + " " + (1-shops[i][0]%2)*(dongr));
//				System.out.println((dongd%2)*(xy[1-dongd/2]-shops[i][1]) + " " + (1-dongd%2)*(shops[i][1]));
			}
			distancesum += distance;
		}
		System.out.println(distancesum);
	}
}
