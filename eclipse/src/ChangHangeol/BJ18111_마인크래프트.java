package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 모든 면의 높이를 똑같게 하는 작업이 필요.
 * i, j의 블럭을 제거하여 저장. 2초
 * 아무대나 놓을 수 있음. 1초
 */
public class BJ18111_마인크래프트 {
	static int R, C, in, mintime, h;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		in = Integer.parseInt(st.nextToken());
		h = 0;
		
		int maxi = 0;
		int mini = 256;
		int count = 0;
		map = new int[257];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int idx = Integer.parseInt(st.nextToken());
				map[idx]++;
				count += idx;
				maxi = Math.max(maxi, idx);
				mini = Math.min(mini, idx);
			}
		}
		mintime = count*2;
		// 입력 완료

		// 높이가 일정해 질 때 까지 반복.
		// 높이 낮추는게 이득?
		// 드는 비용이 같을 땐 무조건 낮추기.
		// 	높이를 높이는게 이득인가?
		//	  높이기.
		//	낮추기.
		run(mini, maxi, 0);
		
		// 작업시간 + " " + 맞춰진 높이 출력.
		System.out.println(mintime + " " + h);
	}
	public static void run(int mini, int maxi, int time) {
		// 백트래킹
		if(time > mintime) return;
		// 높이가 맞춰졌을 때.
		if(mini == maxi) {
			if(mintime > time) {
				mintime = time;
				h = maxi;
				return;
			}
		}
		
		// 작동 코드
		// 아래꺼를 올릴 수 있으면, 아래꺼를 올려서 해보기.
		if(in >= map[mini]) {
			// 아래꺼 올리기.
			map[mini+1] += map[mini];
			in -= map[mini];
			run(mini+1, maxi, time + map[mini]);
			
			// 원상복구
			map[mini+1] -= map[mini];
			in += map[mini];
		}
		// 위에꺼를 깍아서 해보기.
		map[maxi-1] += map[maxi];
		in += map[maxi];
		run(mini, maxi-1, time + 2*map[maxi]);
		
		// 원상복구
		map[maxi-1] -= map[maxi];
		in -= map[maxi];
	}
}

/*

2 2 35
20 10
190 40


*/