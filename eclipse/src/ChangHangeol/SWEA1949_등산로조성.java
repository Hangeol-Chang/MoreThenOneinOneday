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
import java.util.Stack;
import java.util.StringTokenizer;

// dfs로 한번 처리하고 돌아오기
public class SWEA1949_등산로조성 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class loc {
        int r, c, h, drill, dist;
        loc(int r, int c, int h, int drill, int dist) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.drill = drill;
            this.dist = dist;
        }
    }
    static int N, max, maxd;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<loc> que = new LinkedList<>();
            int max = 0;
            map = new int[N+2][N+2];
            for(int r = 1; r <= N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 1; c <= N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());

                    // 최대값들을 큐에 넣어놓음.
                    if(map[r][c] > max) {
                        max = map[r][c];
                        que.clear();
                        que.add(new loc(r, c, max, K, 1));
                    }else if(map[r][c] == max) que.add(new loc(r, c, max, K, 1));
                }
            }
            // 입력 끝.
            
            // 최대값들이 큐에 들어가있음.
            // 방문한곳을 0으로 만들며 진행하기.
            maxd = 0;
            while(!que.isEmpty()){
                Stack<loc> stk = new Stack<>();
                run(que.poll());
            }
            sb.append("#" + t + " " + maxd + "\n");
        }
        System.out.println(sb);
    } 
    public static void run(loc l){
        // 방문처리
        int save = map[l.r][l.c];
        map[l.r][l.c] = 0;

        // 디버그
        // System.out.println(l.r + " " + l.c + ", 거리 : " + l.dist + ", 드릴 : " + l.drill + ", 높이 : " + l.h);
        // for(int r = 1; r <= N; r++){
        //     for(int c = 1; c <= N; c++){
        //         System.out.print(map[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        
        // 갈 수 있는곳이 있는지 없는지 판단.
        boolean can = false;
        for(int d = 0; d < 4; d++){
            int nr = l.r + dr[d];
            int nc = l.c + dc[d];
            
            // 0이면 갈 수 없는거임.
            if(map[nr][nc] == 0) continue;
            // 그냥 내려갈 수 있으면 내려가기.
            else if(map[nr][nc] < l.h){
                run(new loc(nr, nc, map[nr][nc], l.drill, l.dist + 1));
                can = true;
            }
            // 드릴을 사용
            else if(map[nr][nc] - l.drill < l.h) {
                run(new loc(nr, nc, l.h-1, 0, l.dist+1));
                // System.out.println(map[nr][nc] + " " + l.drill + " " + l.h);
                can = true;
            }
        }
        // 갈 수 있는 곳이 없으면, 등산로 길이 비교하고 리턴.
        if(!can){
            maxd = Math.max(maxd, l.dist);
        }
        //원상복귀
        map[l.r][l.c] = save;
        // System.out.println();
    }
}

/*

1
5 1       
9 3 2 3 2 
6 3 1 7 5
3 4 8 9 9
2 3 7 7 7
7 6 5 5 8

1
4 4
8 3 9 5
4 6 8 5
8 1 5 1
4 9 5 5
*/