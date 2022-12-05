import java.util.*;
import java.io.*;


public class Softeer_거리합구하기
{
    static class vertex implements Comparable<vertex> {
        int v, w;
        vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(vertex o) {
            return this.w - o.w;
        }
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        ArrayList<vertex>[] grp = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            grp[u].add(new vertex(v, w));
            grp[v].add(new vertex(u, w));
        }
        // 입력 완료.

        // 1부터 N까지에 대해 전부 해보기.
        for(int i = 1; i <= N; i++) {
            // 정답 배열 선언.
            long[] dijk = new long[N+1];
            dijk[i] = -1;

            PriorityQueue<vertex> que = new PriorityQueue<>();
            for(vertex vr : grp[i]) que.add(vr);
            
            while(!que.isEmpty()) {
                vertex now = que.poll();
                
                // 방문한 적이 있으면 통과.
                if(dijk[now.v] != 0) continue;
                // 방문처리
                dijk[now.v] = now.w;

                for(vertex vr : grp[now.v]) {
                    if(dijk[vr.v] != 0) continue;

                    que.add(new vertex(vr.v, vr.w + now.w));
                }
            }
            long ans = 1;
            for(long dist : dijk) ans += dist;
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}