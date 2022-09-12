import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ15964_이상한기호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        BigInteger c = new BigInteger(Integer.toString(a+b));
        BigInteger d = new BigInteger(Integer.toString(a-b));
        
        System.out.print( c.multiply(d) );
    }
}
