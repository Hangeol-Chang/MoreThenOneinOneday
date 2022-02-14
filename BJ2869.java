import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] abw = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long day = (abw[2]-abw[0])/(abw[0]-abw[1]);
        if((abw[2]-abw[0])%(abw[0]-abw[1]) != 0) day++;
        // long sum = (a-b)*day;

        // while(true){
        //     sum += a;
        //     day++;

        //     if(sum >= w) break;
        //     sum -= b;
        // }
        System.out.println(++day);
    }
    
}
