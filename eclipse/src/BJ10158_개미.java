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

        //상하에 닿을 때, 좌우에 닿을 때로 구분.
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(br.readLine());

        
        //위에가 홀수면 0에서 시작, 짝수면 
        if(hour > (W-x)){
            int xtmp = (hour-(W-x));
            if (xtmp/W %2 == 0) x = W - xtmp%W;
            else                x = xtmp%W;
        }else x += hour;
        
        if(hour > (H-y)){
            int ytmp = (hour-(H-y));
            if (ytmp/H %2 == 0) y = H - ytmp%H;
            else                y = ytmp%H;
        }else y += hour;

        System.out.println(x + " " + y);
    }

    
}
