

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 순열
public class BJ_2022DGIST현풍전산배알고리즘대회_B {
	static int[] sel, satis, pays;
	static boolean[] visited;
	static int N, M;
	static long ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 사용할 만족도와 지불비용 임력
		satis = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		pays = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sel = new int[M];
		visited = new boolean[N];
		
		select(0);
		System.out.println(ans);
	}
	public static void select(int sidx) {
		if(sidx == M) {
			long tmpsum = 0;
			for(int i = 0; i < M; i++)
				tmpsum += sel[i] - pays[i];
			ans = Math.max(ans, tmpsum);
			return;
		}	
		
		for(int i = 0; i < N; i++) {
			// 여기꺼 만족도 못하면 넘기기
			if (satis[i] - pays[sidx] < 0 || visited[i]) continue;
			visited[i] = true;
			sel[sidx] = satis[i];
			select(sidx+1);
			visited[i] = false;
		}
	}
}
