import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1484_다이어트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        
        int x = 1;
        int n = 1;
        Queue<Integer> que = new LinkedList<>();

        while(true) {
            if(x == 1 && 2*n*x + x*x > G) break;

            while(true) {
                int idf = 2*n*x + x*x;
                if(idf >= G) {
                    if(idf == G) que.add(n+x);
                    break;
                }
                else x++;
            }
            n++;
            x--;
            if(x < 1) x = 1;
        }

        if(que.isEmpty()) System.out.println(-1);
        else while(!que.isEmpty()) System.out.println(que.poll());
    }
}