

// 시간 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 내가 방문한 걸 큐에 넣고, distance배열에 이곳에 오는 최소값을 저장함.
public class BJ1753_최단경로 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer stt = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(stt.nextToken());
    	int E = Integer.parseInt(stt.nextToken());
    	
    	@SuppressWarnings("unchecked")
		HashMap<Short, Byte>[] map = new HashMap[V+1];
    	// map에 목표 위치, 가중치를 넣음.
    	for(int i = 0; i < V+1; i++) map[i] = new HashMap<Short, Byte>();
    	// 배열 선언.
    	
    	short st = Short.parseShort(br.readLine());
    	
    	for(int i =0 ; i < E; i++) {
    		stt = new StringTokenizer(br.readLine());
    		
    		short u = Short.parseShort(stt.nextToken());
    		short v = Short.parseShort(stt.nextToken());
    		byte w = Byte.parseByte(stt.nextToken());
    		
    		// 간선이 여러개만 있으면 하나만 써야 함.
    		// 출발점으로 가는 길은 기록하지 않음.
    		if(v != st) {    			
    			if(map[u].containsKey(v)) map[u].put(v, (byte) Math.min(w, map[u].get(v)));
    			else 					  map[u].put(v, w);
    		}
    	}
    	// 입력받기 끝.
//    	br.close();
    	
    	// 거리 담을 배열 초기화
    	int[] distance = new int[V+1];

    	Queue<Short> que = new LinkedList<>();
    	que.add(st);
    	while(!que.isEmpty()) {
    		int loc = que.poll();
    		
    		// loc에서 갈 수 있는 곳 모두에 대해 테스트.
    		for(Map.Entry<Short, Byte> to : map[loc].entrySet()) {
    			// v까지 가는 가중치와, 여기까지 오는 거리를 더해서 넣음.
    			short key = to.getKey();
    			int tmpdist = distance[loc] + to.getValue();
    			
    			// 위치에 있는 거리보다 지금 가는게 더 가까우면, 넣음.
    			if( distance[key] == 0 || tmpdist < distance[key]) {
    				distance[key] = tmpdist;
    				que.add(key);
    			}
    		}
    	}
    	
    	// 출력
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= V; i++) {
    		sb.append((i == st ? 0 : distance[i] > 0 ? distance[i] : "INF") + "\n");
    	}
    	System.out.println(sb);
    }
}
