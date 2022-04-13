package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252_줄세우기 {
	public static void main(String[] args0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] grp = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();
		int[] indegree = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			grp[stt].add(end);
			indegree[end]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			if(indegree[i] == 0) que.add(i);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now + " ");
			
			for(int child : grp[now])
				if(--indegree[child] == 0)
					que.add(child);
		}
		System.out.println(sb);
	}
}
