import java.io.*;
import java.util.*;

public class BJ1417_국회의원선거 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int now = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 1; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));
        // 입력 완료

        int count  = 0;
        while(true && !pq.isEmpty()) {
            int max = pq.poll();

            if(max >= now) {
                count++;
                now++;
                max--;
                pq.add(max);
            }
            else break;
        }
        System.out.print(count);
    }
}
