import java.io.*;
import java.util.*;

public class BJ1059_좋은구간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] map = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(map);
        int S = Integer.parseInt(br.readLine());
        
        int edd = 0;
        while(map[edd] < S) edd++;
        if(map[edd] == S) {
        	System.out.println(0); return;
        }
        
        int stt = edd-1;
        int ans = (S - map[stt]) * (map[edd] - S) - 1;
        System.out.println(ans);
    }
}
