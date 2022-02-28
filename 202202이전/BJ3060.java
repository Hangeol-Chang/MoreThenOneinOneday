import java.util.Scanner;
import java.util.stream.Stream;
public class BJ3060 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();

        for(int t = 0; t < T; t++){
            long food = in.nextInt();
            in.nextLine();

            int[] feed = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            int num = 1;
            int sumfeed = 0;
            for(int feedone : feed) sumfeed += feedone;
            while(food >= sumfeed){
                sumfeed *= 4;
                num++;
            }
            System.out.println(num);
        }
        in.close();
    }
}

/* 4배 */