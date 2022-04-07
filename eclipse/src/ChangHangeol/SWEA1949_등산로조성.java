package ChangHangeol;
/*
제일 높은 곳에서 출발하여, 낮은 곳으로 내려감.
제일 높은 곳은 최대 5개 주어짐.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs로 한번 처리하고 돌아오기
public class SWEA1949_등산로조성 {
    static class loc {
        int r, c, h, drill;
        loc(int r, int c, int h, int drill) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.drill = drill;
        }
    }
    int N;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<loc> que = new LinkedList<>();
            int max = 0;
            map = new int[N+2][N+2];
            for(int r = 1; r <= N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 1; c <= N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if(map[r][c] > max) {
                        max = map[r][c];
                        que.add(new loc(r, c, max, K));
                    }else if(map[r][c] == max) que.add(new loc(r, c, max, K));
                }
            }

            while(!que.isEmpty()){
                loc location = que.poll();
                run();
            }
            sb.append("#" + t + " " + "ans" + "\n");
        }
    }
    public static void run(){

    }    
}
