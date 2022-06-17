

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 모든 도시의 쌍에 대해, 최소경로 찍기.
public class BJ11404_플로이드 {
    static class node implements Comparable<node> {
        int v, w;
        node(int v, int w){
            this.v = v; this.w = w;
        }
        @Override
        public int compareTo(node o) {
            return this.w - o.w;
        }        
    }
    static ArrayList<node>[] arr;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ansb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            arr[u].add(new node(v, w));
        }
        // 입력 완
        for(int U = 1; U <= N; U++){
            dist = new int[N+1];
            daikstra(U);
            // 정답 배열 입력
            for(int V = 1; V <= N; V++){
                ansb.append((V==U) ? "0 " : dist[V] + " ");
            }
            ansb.append("\n");
        }
        System.out.println(ansb);
    }
    public static void daikstra(int st){
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(st, 0));
        
        while(!pq.isEmpty()){
            node now = pq.poll();
            // 방문한 적 있으면 째기
            if(dist[now.v] != 0) continue;
            // 길이 대입
            dist[now.v] = now.w;

            for(node nd : arr[now.v]){
                if(dist[nd.v] != 0) continue;
                
                pq.add(new node(nd.v, now.w + nd.w));
            }
        }
    }
}
