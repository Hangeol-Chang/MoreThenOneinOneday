package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 내가 방문한 걸 큐에 넣고, visited배열에 이곳에 오는 최소값을 저장함.
// 
public class BJ1753_최단경로 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer stt = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(stt.nextToken());
    	int E = Integer.parseInt(stt.nextToken());
    	
    	int[][] map = new int[V+1][V+1];
    	int st = Integer.parseInt(br.readLine());
    	
    	for(int i =0 ; i < E; i++) {
    		stt = new StringTokenizer(br.readLine());
    		
    		int u = Integer.parseInt(stt.nextToken());
    		int v = Integer.parseInt(stt.nextToken());
    		int w = Integer.parseInt(stt.nextToken());
    		
    		map[u][v] = w;
    	}
    	// 입력받기 끝.
//    	br.close();
    	
    	Queue<Integer> que = new LinkedList<Integer>();
    	que.add(st);
    	while(!que.isEmpty()) {
    		int loc = que.poll();
    		
    		for(int i = 1; i <= V; i++) {
    			
    		}
    	}
    }
}
