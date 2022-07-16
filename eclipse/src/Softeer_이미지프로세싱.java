import java.util.*;
import java.io.*;

/*
H * W 크기의 이미지 H, W <= 128
각 픽셀에 색상(1 ~ 10^9)
색 C_i,j
명령 (i, j, c)
(i, j) 와 붙어있는 같은 색들을 전부 c로 바꿔버림.

연산이 완료된 후의 배열 출력할 것.
*/
public class Softeer_이미지프로세싱
{
    // 탐색용 배열.
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};

    public static class loc {
        int h, w;
        loc(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        // 색이 0으로 칠해지는 경우는 없기에, 맵을 0으로 초기화해도 됨.
        int[][] map = new int[H+2][W+2];
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 맵 입력 완료.

        int Q = Integer.parseInt(br.readLine());
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int val = map[h][w];
            map[h][w] = c;

            Queue<loc> que = new LinkedList<>();
            que.add(new loc(h, w));

            while(!que.isEmpty()) {
                loc now = que.poll();

                for(int d = 0; d < 4; d++) {
                    int nh = now.h + dh[d];
                    int nw = now.w + dw[d];

                    if(map[nh][nw] == val) {
                        map[nh][nw] = c;
                        que.add(new loc(nh, nw));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                sb.append(map[i][j] + " ");
            }   
            sb.append("\n");
        }
        System.out.print(sb);
    }
}