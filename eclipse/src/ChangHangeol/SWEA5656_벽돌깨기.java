package ChangHangeol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기{
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
        }
    }
    public void boom(int n){
        Queue<Integer> que = new Queue<>();
        // 깊은 복사가 필요함.
        if(n >= 1) boom(n-1);
    }
}

