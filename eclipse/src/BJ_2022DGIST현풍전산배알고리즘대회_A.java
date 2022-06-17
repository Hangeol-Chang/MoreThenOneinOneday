

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2022DGIST현풍전산배알고리즘대회_A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 전체 밀린 시간을 계산하고, 이를 시간과 분으로 나누어 저장.
		// 0 ~ 1439 까지 하루

		ArrayList<Integer> times = new ArrayList<>();
		
		int now = -180 - K;
		// 처음에 +1440 + K 해서 900에 맞춤
		while(now < (N+1)*1440) {
			// 하루 더하기
			now += 900 + K;
			for(int i = 0; i < 3; i++) {
				// 꺼지는 시간 체크
				now += 180;
				if(now >= N*1440 && now < (N+1)*1440) {
					times.add(now);
				}
			}
		}
		System.out.println(times.size());
		for(int time : times) {
			System.out.printf("%02d:%02d\n",(time - N*1440)/60, time%60);
		}
	}
}
