package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA1486_장훈이의높은선반 {
	static int[] nums;
	static int N, H;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			min = 0;
			for(int num : nums) {
				min += num;
				if(min >= H) break;
			}

			dlfmawjdgkrldjfuqek(0, 0, 0);
			sb.append((min-H) + "\n");
		}
		System.out.println(sb);
	}
	// 방문위치들, 합, 검색을 시작할 위치.
	public static void dlfmawjdgkrldjfuqek(int visited, int sum, int idx) {
		if(sum >= min) return;
		if(sum >= H) {
//			System.out.println("통과 : " + sum);
			min = Math.min(sum, min);
			return;
		}
//		System.out.println(sum);
		// 2를 먼저 잡고, 1을 잡는 그런 중복된 것들 걸러줘야 함. 그래서 idx부터 출발.
		for(int i = idx; i < N; i++) {
			if((visited & 1<<i) > 0) continue;
			dlfmawjdgkrldjfuqek(visited | 1<<i, sum + nums[i], i+1);
		}
	}
}
