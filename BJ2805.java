import java.util.Scanner;
import java.util.stream.Stream;

public class BJ2805 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            int n =in.nextInt();
            int hn = n/2;
            in.nextLine();
            
            //입력받기
            int[][] farm = new int[n][];
            for(int i = 0; i < n; i++){
                farm[i] = Stream.of(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            int sum = 0;
            for(int y = 0; y < n; y++){
                for(int x = 0; x < n; x++){
                    if( y <= x + hn &&
                        y <= -x + 3*hn &&
                        y >= -x + hn &&
                        y >= x - hn){
                            sum += farm[y][x];
                        }
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
        in.close();
    }
}
