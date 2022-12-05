import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ7453_합이0인네정수 {
    static int size;
    static int[][] sums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[4][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int d = 0; d < 4; d++)
                map[d][i] = Integer.parseInt(st.nextToken());
        }
        // 입력 완료.
        
        size = N*N;
        sums = new int[2][size];

        // 합치기.
        for(int d = 0; d < 2; d ++){
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    sums[d][i*N + j] = map[d][i] + map[d+2][j];
        }
        Arrays.sort(sums[1]);

        long ans = 0;
        // 이분탐색으로 답 찾기.
        for(int n : sums[0]){
            long u = uppersearch(-1 * n);
            long l = lowersearch(-1 * n);
            ans += u-l;
        }

        System.out.print(ans);
    }
    public static int uppersearch(int target){
        int l = 0;
        int r = size;
        
        while(l < r) {
            int mid = (l + r) / 2;
            int num = sums[1][mid];

            if (target >= num) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    public static long lowersearch(int target){
        int l = 0;
        int r = size;
        
        while(l < r) {
            int mid = (l + r) / 2;
            int num = sums[1][mid];

            if (target <= num) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
