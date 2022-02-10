import java.util.Scanner;
import java.util.stream.Stream;

public class SWEA2063{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        in.nextLine();
        int[] nums = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        in.close();
        int m = (n+1)/2;

        //선택정렬로 중간까지만 뽑기.
        for(int i = 0; i < m; i++){
            int idx = i;
            for(int j = i; j < n; j++){
                if(nums[j] < nums[idx]) idx = j;
            }
            //위치바꾸기
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
        }
        System.out.println(nums[m-1]);
    }
}