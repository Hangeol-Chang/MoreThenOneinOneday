

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1865_웜홀 {
    static class node {
        int u, v, w;
        node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        test : for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            // 전체 노드 수
            int N = Integer.parseInt(st.nextToken());
            // 도로의 수 N
            int M = Integer.parseInt(st.nextToken());
            // 웜홀의 수 W
            int W = Integer.parseInt(st.nextToken());

            node[] grp = new node[2*M+W];
            // 도로 입력받기.
            for(int i = 0; i < 2*M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                grp[i] = new node(u, v, w);
                grp[++i] = new node(v, u, w);
            }
            // 웜홀 입력받기.
            for(int i = 2*M; i < W+2*M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                grp[i] = new node(u, v, -w);
            }
            // 입력받기 끝.
            
            // 1번을 시작노드로 잡기.
            // 전체 노드 수-1만큼 진행하면서, 최단거리 잡기.
            int[] dist = new int[N+1];
            Arrays.fill(dist, 1000000001);
            // 벨만-포드 알고리즘.
            for(int p = 0; p < N-1; p++)
                for(node nd : grp)
                    dist[nd.v] = Math.min(dist[nd.u] + nd.w, dist[nd.v]);

            // 여기서 갱신되면 음수순환이 존재.
            for(node nd : grp)
                if(dist[nd.v] > dist[nd.u] + nd.w){
                    sb.append("YES\n");
                    continue test;
                }

            //여기에 튀어나오면 경우가 없는 것.
            sb.append("NO\n");
        }
        System.out.println(sb);
    }
}

/*

2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8

*/