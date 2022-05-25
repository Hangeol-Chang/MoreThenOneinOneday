package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ4344_평균은넘겠지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int[] map = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = map[0];
			
			int sum = 0;
			for(int i = 1; i <= n; i++) sum += map[i];
			float avg = sum*1.0f/n;
			
			int count = 0;
			for(int i = 1; i <= n; i++) if(map[i] > avg) count++;
			
			sb.append(String.format("%.3f", 100*count*1.0f/n) + "%\n");
		}
		System.out.println(sb);
	}
}
