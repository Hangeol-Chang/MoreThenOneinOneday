import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ1247부호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int T = 0; T < 3; T++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < N; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            int res = sum.compareTo(BigInteger.ZERO);

            if(res > 0) sb.append("+\n");
            else if (res < 0) sb.append("-\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
    }
}
