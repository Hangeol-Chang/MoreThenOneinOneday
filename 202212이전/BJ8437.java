import java.math.*;
import java.io.*;

public class BJ8437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger divider = new BigInteger("2");

        BigInteger c = a.add(b).divide(divider);
        System.out.println(c);
        System.out.print(c.subtract(b));
    }
}