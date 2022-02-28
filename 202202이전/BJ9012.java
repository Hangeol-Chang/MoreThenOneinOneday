import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BJ9012 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            String str = bf.readLine();
            int len = str.length();
            byte calc = 0;

            for(int j = 0; j < len; j++){
                switch(str.charAt(j)){
                    case '(' :
                        calc++;
                        break;
                    case ')' :
                        calc--;
                        break;
                }
                if(calc < 0) break;
            }
            sb.append(calc == 0 ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
