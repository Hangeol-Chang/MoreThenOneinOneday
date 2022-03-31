package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 내가 방문한 걸 큐에 넣고, distance배열에 이곳에 오는 최소값을 저장함.
public class BJ1753_최단경로2 {
	static class Node implements Comparable<Node> {
		short v;
		int w;
		
		Node(short v, int tmpdist){
			this.v = v;
			this.w = tmpdist;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer stt = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(stt.nextToken());
    	int E = Integer.parseInt(stt.nextToken());
    	
    	@SuppressWarnings("unchecked")
    	// map에 목표 위치, 가중치를 넣음.
    	// 배열 선언.
		ArrayList<Node>[] map = new ArrayList[V+1];
    	for(int i = 0; i < V+1; i++) map[i] = new ArrayList<>();
    	
    	// 시작 위치
    	short st = Short.parseShort(br.readLine());
    	
    	for(int i =0 ; i < E; i++) {
    		stt = new StringTokenizer(br.readLine());
    		
    		short u = Short.parseShort(stt.nextToken());
    		short v = Short.parseShort(stt.nextToken());
    		byte w = Byte.parseByte(stt.nextToken());
    		
    		// 간선 다 때려박기.
    		map[u].add(new Node(v, w));
    	}
    	// 입력받기 끝.
    	
    	// 거리 담을 배열 초기화
    	int[] distance = new int[V+1];
    	Arrays.fill(distance, 4000000);
    	distance[st] = 0;
    	boolean[] visited = new boolean[V+1];

    	// 이 큐에 들어가는 노드는, 위에 배열에서 쓰는 노드와 다른 개념임.
    	// 여기의 노드의 v는 나의 위치이고, w는 distance[v]임.
    	PriorityQueue<Node> que = new PriorityQueue<>();
    	que.add(new Node(st, (byte)0));
    	while(!que.isEmpty()) {
    		Node loc = que.poll();
    		
    		if(visited[loc.v]) continue;
    		visited[loc.v] = true;
    		
    		// loc에서 갈 수 있는 곳 모두에 대해 테스트.
    		for(Node to : map[loc.v]) {
    			// v까지 가는 가중치와, 여기까지 오는 거리를 더해서 넣음.
    			int tmpdist = loc.w + to.w;
    			
    			// 위치에 있는 거리보다 지금 가는게 더 가까우면, 넣음.
    			if(tmpdist < distance[to.v]) {
    				distance[to.v] = tmpdist;
    				que.add(new Node(to.v, tmpdist));
    			}
    		}
    	}
    	
    	// 출력
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= V; i++) {
    		sb.append((distance[i] < 4000000 ? distance[i] : "INF") + "\n");
    	}
    	System.out.println(sb);
    }
}
