package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1865_웜홀 {
    static class node implements Comparable<node> {
        int v, w;
        node(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(node o) {
            return this.w - o.w;
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

            ArrayList<node>[] grp = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) grp[i] = new ArrayList<>();
            // 도로 입력받기.
            for(int i = 1; i <= M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                grp[u].add(new node(v, w));
            }
            // 웜홀 입력받기.
            for(int i = 1; i <= W; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                grp[u].add(new node(v, -w));
            }
            // 입력받기 끝.
            
            // 1번을 시작노드로 잡기.
            


            //여기에 튀어나오면 경우가 업는 것.
            sb.append("NO\n");
        }
        System.out.println(sb);
    }
}
