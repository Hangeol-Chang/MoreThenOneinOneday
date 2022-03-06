package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1546_평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	sum += tmp;
        	max = Math.max(max,  tmp);
        }
        //System.out.println(sum + " " + max + " " + n);
        double avg = 100.0 * sum / max / n;
        
        System.out.printf("%f", avg);
        
    }
}
