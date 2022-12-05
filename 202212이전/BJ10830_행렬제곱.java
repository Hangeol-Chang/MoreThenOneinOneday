import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10830_행렬제곱 {
    static int psize;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num;

        psize = Integer.parseInt(st.nextToken());
        num = Long.parseLong(st.nextToken());

        int[][] p = new int[psize][psize];
        
        for(int i = 0; i < psize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < psize; j++) 
                p[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }
        // 입력 완료.

        int[][] ans = calc(num, p);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < psize; i++){
            for(int j = 0; j < psize; j++)
                sb.append(ans[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] calc(long num, int[][] p) {
        if(num == 1) return p;

        int[][] x = calc(num/2, p);
        int[][] mx = multiple(x, x);
        
        // System.out.println(num);
        // for(int i = 0; i < psize; i++){
        //     for(int j = 0; j < psize; j++){
        //         System.out.print(mx[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        if(num % 2 == 0) return mx;
        else             return multiple(mx, p);
    }

    public static  int[][] multiple(int[][] p1, int[][] p2) {
        int[][] newp = new int[psize][psize];

        for(int i = 0; i < psize; i++) {
            for(int j = 0; j < psize; j++) {
                int tmp = 0;
                
                for(int t = 0; t < psize; t++)
                    tmp += p1[i][t] * p2[t][j];

                newp[i][j] = tmp % 1000;
            }
        }
        return newp;
    }
}