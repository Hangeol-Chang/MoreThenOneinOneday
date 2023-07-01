import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ4158_CD {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < N+M; i++){
                set.add(Integer.parseInt(br.readLine()));
            }
            sb.append(N + M - set.size() + "\n");
        }
        System.out.print(sb);
    }
}