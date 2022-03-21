package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class BJ11725_트리의부모찾기 {
	static boolean[][] graph;
	static short[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new boolean[N+1][N+1];
		parents = new short[N+1];
		Queue<Short> que = new LinkedList<>();
		
		int[] nodes;
		for(int i = 0; i < N-1; i++) {
			nodes = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			graph[nodes[0]][nodes[1]] = true;
			graph[nodes[1]][nodes[0]] = true;
		}
		// 그래프 입력 끝.
		
		// 1부터 시작해서,
		// 큐에 부모를 다 떄려 넣으면서 계산하기.
		que.add((short) 1);
		while(!que.isEmpty()) {
			short p = que.poll();
			
			for(short i = 2; i <= N; i++) {
				if(graph[p][i]) {
					que.add(i);
					parents[i] = p;
					graph[p][i] = false;
					graph[i][p] = false;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) { sb.append(parents[i] + "\n"); }
		System.out.println(sb);
	}
}
