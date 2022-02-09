import java.util.Scanner;
import java.util.stream.Stream;
public class SWEA1966 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        in.nextLine();
        
        for(int i = 1; i < T+1; i++){
            sb.append("#").append(i);
            
            //입력받기
            int n = in.nextInt();
            in.nextLine();
            int[] map = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            //버블 솔트
            //오름차순으로, 앞에꺼부터 정렬하여
            //정렬한 값을 바로 sb에 넣음.
            for(int j = 0; j < n; j++){
                for (int k = n-2; k >= j; k--){
                    if(map[k] > map[k+1]){
                        int tmp  = map[k];
                        map[k] = map[k+1];
                        map[k+1] = tmp;
                    }

                }
                sb.append(" ").append(map[j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}
