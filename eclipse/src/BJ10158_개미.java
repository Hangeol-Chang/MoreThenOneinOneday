import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10158_개미 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int dr = 1;
        int dc = 1;

        //상하에 닿을 때, 좌우에 닿을 때로 구분.
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(br.readLine());

        int nr = y;
        int nc = x;
        for(int h = 0; h < hour; h++){
            nr += dr;
            nc += dc;

            if(nc < 0 || nc > W) {
                dc = -dc;
                nc += 2*dc;
            }
            if(nr < 0 || nr > H) {
                dr = -dr;
                nr += 2*dr;
            }
            //System.out.println(nc + " " + nr);
        }
        System.out.println(nc + " " + nr);
    }
}
