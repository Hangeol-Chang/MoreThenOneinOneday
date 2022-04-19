package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 모든 면의 높이를 똑같게 하는 작업이 필요.
 * i, j의 블럭을 제거하여 저장. 2초
 * 아무대나 놓을 수 있음. 1초
 */
public class BJ18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int in = Integer.parseInt(st.nextToken());
		
		int maxi = 0;
		int mini = 256;
		int[] map = new int[257];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int idx = Integer.parseInt(st.nextToken());
				map[idx]++;
				maxi = Math.max(maxi, idx);
				mini = Math.min(mini, idx);
			}
		}
		// 입력 완료

		// 높이가 일정해 질 때 까지 반복.
		// 높이 낮추는게 이득?
		// 드는 비용이 같을 땐 무조건 낮추기.
		// 	높이를 높이는게 이득인가?
		//	  높이기.
		//	낮추기.
		int time = 0;
		while(mini != maxi) {
			// 높이는게 이득.
			if(map[maxi]*2 > map[mini] && in >= map[mini]) {
				map[mini+1] += map[mini];
				time += map[mini];
				mini++;
			}
			// 낮추는게 이득.
			else {
				map[maxi-1] += map[maxi];
				time += map[maxi]*2;
				maxi--;
			}
		}
		
		// 작업시간 + " " + 맞춰진 높이 출력.
		System.out.println(time + " " + maxi);
	}
}

/*

2 2 35
20 10
190 40

*/