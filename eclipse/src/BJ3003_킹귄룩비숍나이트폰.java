import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3003_킹귄룩비숍나이트폰 {
    
    static int[] pawn = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 6; i++) {
            int a = Integer.parseInt(st.nextToken());
            System.out.print( pawn[i] - a + " ");
        }
    }
}