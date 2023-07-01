import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ14928_큰수BIG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int divider = 20000303;
        String ini = br.readLine();
        
        int a = 0;
        if(ini.length() > 8) {
            a = Integer.parseInt(ini.substring(ini.length() - 8, ini.length()));
        }
        else{ a = Integer.parseInt(ini); }

        // System.out.println(a);
        System.out.print(a % divider);
    }
}
