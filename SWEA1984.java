import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA1984 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = in.nextInt();
        in.nextLine();
        
        for(int t = 1; t <= n; t++){
            sb.append("#").append(t).append(" ");

            int[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            //최솟값, 최대값 위치 찾기
            int idxmin = 0;
            for(int i = 0; i < 10; i++){
                if(nums[i] < nums[idxmin]) idxmin = i;
            }
            //최소겂변경
            int tmp = nums[idxmin];
            nums[idxmin] = nums[0];
            nums[0] = tmp;

            int idxmax = 9;
            for(int i = 9; i >= 0; i--){
                if(nums[i] > nums[idxmax]) idxmax = i;
            }
            //최대값변경
            tmp = nums[idxmax];
            nums[idxmax] = nums[9];
            nums[9] = tmp;
            
            //평균 구하기
            int avg = 4;

            if(t == 4){
                for(int num : nums) System.out.print(num + " ");
                System.out.println();
            }
            for(int i = 1; i <= 8; i++) avg += nums[i];
            avg /= 8;


            sb.append(avg).append("\n");
        }
        System.out.println(sb);
        in.close();
    }
}
/*
3 17 1 39 8 41 2 32 99 2
22 8 5 123 7 2 63 7 3 46
6 63 2 3 58 76 21 33 8 1


*/
/*
#1 18
#2 20
#3 24
#4 89
#5 262
#6 2391
#7 207
#8 265
#9 217
#10 165
*/