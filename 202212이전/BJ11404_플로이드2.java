

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 모든 도시의 쌍에 대해, 최소경로 찍기.
public class BJ11404_플로이드2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ansb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 배열 초기화
        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) Arrays.fill(arr[i], 10000001);

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            arr[u][v] = Math.min(w, arr[u][v]);
        }
        // 입력 완
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                for(int k = 1; k <= N; k++){
                    if(k == i || k == j) continue;
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                ansb.append((j==i) ? "0 " : (arr[i][j] == 10000001) ? "0 " : arr[i][j] + " ");
            }
            ansb.append("\n");
        }
        System.out.println(ansb);
    }
}
