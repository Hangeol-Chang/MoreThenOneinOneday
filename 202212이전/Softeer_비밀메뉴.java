import java.util.*;
import java.io.*;


public class Softeer_비밀메뉴
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] key = new int[M];
        int[] clk = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) key[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i  =0; i < N; i++) clk[i] = Integer.parseInt(st.nextToken());
        
        int clkp = 0;
        while(clkp < N - M + 1) {
            // 스타트 위치 판단.
            if(key[0] == clk[clkp]) {
                int keyp = 0;
                
                while((keyp < M) && (clkp + keyp < N) && key[keyp] == (clk[clkp + keyp])) {
                    keyp++;
                }
                if(keyp == M) {
                    System.out.println("secret");
                    return;   
                }
            }
            clkp++;
        }
        System.out.println("normal");
        
    }
}