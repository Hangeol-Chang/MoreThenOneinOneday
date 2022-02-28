package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10158_개미 {
    static int hour;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        hour = Integer.parseInt(br.readLine());

        //상하에 닿을 때, 좌우에 닿을 때로 구분.
        x = W - Math.abs(W - (hour+x)%(2*W));
        y = H - Math.abs(H - (hour+y)%(2*H));

        System.out.println(x + " " + y);
    }
}
