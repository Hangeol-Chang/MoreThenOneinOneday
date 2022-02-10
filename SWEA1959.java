import java.util.Scanner;
import java.util.stream.Stream;
public class SWEA1959 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");

            //크기가 더 작은 배열을 a에 넣을거임.
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            int[] a;
            int[] b;

            //n과 m의 차.
            int cha = 0;
            if(n <= m) {
                cha = m - n;
                a = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                b = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }else{
                cha = n - m;
                b = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                a = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int sum = 0;
            int len = a.length;
            for( int i = 0; i <= cha; i++){
                int tmpsum = 0;
                for(int j = 0; j < len; j++){
                    //System.out.print(a[j] + " " + b[j+i] + " || ");
                    tmpsum += a[j] * b[j+i]; 
                }
                //System.out.println(tmpsum);
                if(tmpsum > sum) sum = tmpsum;
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
