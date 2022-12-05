

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
각 크기의 색종이를 5개씩 가지고 있음.

 */
public class BJ17136_색종이붙이기 {
	// 그냥 인덱싱 잡기 귀찮아서 해놓음.
	static int[][] map = new int[14][14];
	static int count = 0;
	static int mincount;
	static int[] papers = {5,5,5,5,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++)
				count += map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 입력완료.
		mincount = 25;
		run(0);
		System.out.println(mincount == 25 ? -1 : mincount);
	}
	
	public static void run(int nowcount) {
		// 지워야 할 남은 양 > 
		if(nowcount > mincount) return;
		
//		for(int i = 0; i < 10; i++) {
//			for(int j = 0; j < 10; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		if(count == 0) {
			mincount = Math.min(mincount, nowcount);
			return;
		}
		// count를 깍아가면서 작업할거임. 
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if( map[i][j] == 0) continue;
				
				// 1이 잡혔으면, 각 사이즈별로 깍아보기.
				mod : for(int d = 4; d >= 0; d--) {
					if(papers[d] == 0) continue;
					
					// 이어지지 않으면 다음꺼 진행
					for(int rr = 0; rr <= d; rr++)
						for(int cc = 0; cc <= d; cc++)
							if(map[i + rr][j + cc] == 0) continue mod;
					
					// 0으로 만들기.
					papers[d]--;
					for(int rr = 0; rr <= d; rr++)
						for(int cc = 0; cc <= d; cc++) {
							map[i + rr][j + cc] = 0;
							count--;
						}
					
					run(nowcount+1);
					
					// 원상복귀
					papers[d]++;
					for(int rr = 0; rr <= d; rr++)
						for(int cc = 0; cc <= d; cc++) {
							map[i + rr][j + cc] = 1;
							count++;
						}
				}
				// 한번에 하나의 위치에서만 계산.
				return;
			}
		}
	}
}
