//이거 코드 좀 잘 짠듯
import java.util.Scanner;
import java.util.stream.Stream;

public class BJ1085 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        //x, y, w, h
        int[] loc = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        in.close();

        if(loc[0] * 2 > loc[2] ) loc[0] = loc[2] - loc[0];
        if(loc[1] * 2 > loc[3] ) loc[1] = loc[3] - loc[1];

        System.out.println( (loc[0] < loc[1]) ? loc[0] : loc[1] );
    }
}

// 1/4사분면으로 모아서 축까지의 거리만 계산