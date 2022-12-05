import java.util.*;
import java.io.*;


/*

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
2 3 5 9 17

*/

public class Softeer_지도자동구축
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 2;
        for(int i = 1; i <= N; i++) {
            ans += ans-1;
        }
        ans = (int)Math.pow(ans, 2);
        System.out.print(ans);
    }
}