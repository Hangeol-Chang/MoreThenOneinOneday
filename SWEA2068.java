import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA2068{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //스트링빌더에 답 더헤서 출력할거임.
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();

        for(int i = 1; i < T+1; i++){
            sb.append("#").append(i).append(" ");

            int[] map = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = map[0];
            
            //배열 다돌리면서 맥스값 찾기.
            for(int j = 1; j < 10; j++){
                if(max < map[j]) max = map[j];
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}