import java.util.Scanner;
public class SWEA_gravity {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] count = new int[n+1];
        //쌓여있는 박스의 최대 높이
        int max = 0;
        //박스가 있는 위치
        int minindex = 0;

        //입력받아서, 그 높이에 있는 박스들 세기
        for(int i = 0; i < n; i++){
            int tmp = in.nextInt();
            count[tmp]++;

            //맥스값보다 큰 값이 들어오면, 최대높이 변경.
            if(tmp > max) {
                max = tmp;

                //박스의 위치도 새로 잡음.
                minindex = i;
            }
            
        }

        //박스의 가로길이에서, 최대높이에 있는 박스 수량 뺀 것이 답.
        System.out.println( n - count[max] - minindex);
        in.close();
    }
}
