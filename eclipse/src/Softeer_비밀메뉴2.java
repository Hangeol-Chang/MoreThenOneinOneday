import java.util.*;
import java.io.*;


public class Softeer_비밀메뉴2
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //dp 사용
        // N : 1번째 입력 길이.
        // M : 2번째 입력 길이.
        // K : 입력에 포함된 최대 수.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N+1];
        int[] b = new int[M+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) b[i] = Integer.parseInt(st.nextToken());
        // 입력완료.

        // 각 자리에서 최대길이가 될 수 있는 것을 찾아나감.
        int[][] dp = new int[N+1][M+1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(a[i] == b[j]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
            }
        System.out.print(dp[N][M]);
    }
}

/*
    1 3 2 1 3 2 1 3 2 1
2 | 0 0 1 1 1 1 1 1 1 1
1 | 1 1 1 2 2 2 2 2 2 2
3 | 1 2 2 2 3 3 3 3 3 3
2 | 1 2 
a[i] == b[j] 이면, dp[i-1][j-1] + 1과 dp[i-1][j] dp[i][j-1]을 비교,



*/