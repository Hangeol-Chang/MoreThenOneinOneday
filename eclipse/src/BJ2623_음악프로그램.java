

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2623_음악프로그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int tot = 0;
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] grp = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) continue;
			
			int f = Integer.parseInt(st.nextToken());
			for(int j = 0; j < a-1; j++) {
				int b = Integer.parseInt(st.nextToken());
				indegree[b]++;
				tot++;
				grp[f].add(b);
				f = b;
			}
		}
		// 그래프 생성 완료.
		
		// 디버그
//		System.out.println(Arrays.toString(indegree) + " " + tot);
//		for(int i = 1; i <= N; i++) {
//			System.out.println(grp[i].toString());
//		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
			if(indegree[i] == 0) que.add(i);
		
		StringBuilder ans = new StringBuilder();
		while(!que.isEmpty()) {
			int now = que.poll();
			ans.append(now + "\n");
			
			for(int num : grp[now]) {
				indegree[num]--;
				tot--;
				if(indegree[num] == 0)
					que.add(num);
			}
		}
		
		if(tot != 0) System.out.print(0);
		else System.out.println(ans);
		
	}
}
