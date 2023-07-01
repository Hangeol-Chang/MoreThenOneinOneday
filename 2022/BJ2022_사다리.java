import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2022_사다리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0;
        double right = Math.min(x, y);
        
        while( left < right ) {
            double t = (right + left) / 2;
            double mid = (Math.sqrt(x*x - t*t) * Math.sqrt(y*y - t*t)) / 
                         (Math.sqrt(x*x - t*t) + Math.sqrt(y*y - t*t));
            // System.out.println(t + " " + mid);

            if(mid < c - 0.0001D) right = t - 0.0001D;
            else if (mid > c + 0.0001D) left = t + 0.0001D;
            else {
                System.out.printf("%.3f", t);
                return;
            }
        }
        System.out.printf("%.3f",right);
    }
}
