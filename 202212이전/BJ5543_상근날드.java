import java.io.*;

public class BJ5543_상근날드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        int num1 = Math.min(a, Math.min(b, c));
        int num2 = Math.min(d, e);
        
        System.out.print(num1+num2-50);
    }
}