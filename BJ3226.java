import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BJ3226 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(in.readLine());
        int pay = 0;

        for(int i = 0; i < n; i++){
            int[] hmd = Stream.of(in.readLine().split(" |:")).mapToInt(Integer::parseInt).toArray();
            
            pay += hmd[2]*5;
            if (hmd[1] + hmd[2] > 60){
                
            }
            
        }
        
    }
}
/*
0000 ~ 0700

0700 ~ 1900

1900 ~ 0000

19로 나눴을 때, 나머지가 7 ~ 18 이면 
*/