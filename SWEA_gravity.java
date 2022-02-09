import java.util.Scanner;
import java.util.stream.Stream;
public class SWEA_gravity {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        int[] count = new int[n+1];
        //쌓여있는 박스의 최대 높이
        int max = 0;

        //입력받아서, 그 높이에 있는 박스들 세기
        int[] boxs = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = n-1; i >= 0; i--){
            int tmp = boxs[i];
            for(int j = 0; j <= tmp; j++){
                count[j]++;
            }
            if( n - i - count[tmp] > max) max = n-i -count[tmp];
        }

        //박스의 가로길이에서, 최대높이에 있는 박스 수량과 떨어지기 시작하는 박스의 위치를 뺸 것이 답.
        System.out.println(max);
        in.close();
    }
}
