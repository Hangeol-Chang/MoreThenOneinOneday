/**
 * n이 주어지면,
 * 1부터 찍어 올라가면서, 최소값 찾기.
 * 
 * minimum[0]은 0, minumum[1]은 0이 기본적으로 깔리고 들어감.
 * 
 * 2 이상에 숫자들에서, 당연하게도 1씩 빼는것보다, 2, 3으로 나누는게 효율이 좋으므로,
 * n 보다 작은 수들 중, 2 or 3의 배수까지 접근(1씩 빼면서)
 * 그리고, 이 수를 2, 3으로 나눠보고 나온 수까지 오는데 필요한 minimum값 +1을 함.
 * 각 상황들에 대해 대소비교를 해서, 제일 작은 값을 minimum[n]으로 넣음.
 * 
 * 솔직히 시간초과 뜰 줄 알았는데, 잘 통과하네?
 */

import java.util.Scanner;
public class BJ1463 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    
        int n = in.nextInt();
        int[] minimum = new int[n+1];
        minimum[0] = 0;
        minimum[1] = 0;

        //2, 3으로 나눈 나머지를 확인할 변수
        int[] var = {2, 3};

        for(int i = 2; i <= n; i++){
            
            //min의 최대값은 i-1임.
            int min = i - 1;
            for(int j = 0; j < 2; j++){
                
                // i % var[j] : var에 있는 수로 나눈 나머지(2, 3배수가 되기 위해 빼야 할 1의 양)
                // minimun[i/var[j]] L: 2, 3으로 나누고, 그 수의 minimum을 가져옴.
                int tmp = i % var[j] + minimum[i/var[j]] + 1;
                if(tmp < min) min = tmp;
            }

            //저 for문을 돌고 나온 수를 배열에 넣음
            minimum[i] = min;
        }
        System.out.println(minimum[n]);
        in.close();
    }
}
