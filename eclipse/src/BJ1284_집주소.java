import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1284_집주소 {
    public static void main(String[] args) throws IOException{
        String a = "1+0";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int ans = 1;
            String in = br.readLine();
            if(in.equals("0")) break;

            for(char c : in.toCharArray()) {
                int idf = a.indexOf(c);

                if(idf >= 0) ans += a.indexOf(c) + 3;
                else ans += 4;
            }
            sb.append(ans + "\n");    
        }
        
        System.out.print(sb);
    }
}
