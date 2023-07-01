

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class BJ11725_트리의부모찾기 {
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
		parents = new int[N+1];
		Queue<Integer> que = new LinkedList<>();
		
		int[] node;
		for(int i = 0; i < N-1; i++) {
			node = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph[node[0]].add(node[1]);
			graph[node[1]].add(node[0]);
		}
		// 그래프 입력 끝.
		
		// 1부터 시작해서,
		// 큐에 부모를 다 떄려 넣으면서 계산하기.
		que.add(1);
		while(!que.isEmpty()){
			int parent = que.poll();
			for(int nd : graph[parent]) {
				// 연결된 노드에 방문한 적이 없으면
				if(parents[nd] == 0) {

					que.add(nd);
					parents[nd] = parent;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) { sb.append(parents[i] + "\n"); }
		System.out.println(sb);
	}
}
