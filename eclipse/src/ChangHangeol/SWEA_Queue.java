package ChangHangeol;
import java.util.Scanner;
import java.util.stream.Stream;
public class SWEA_Queue {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            int n = in.nextInt();
            int order = in.nextInt();
            in.nextLine();

            int[] arr = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append("#" + t + " " + arr[order%n] + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}
