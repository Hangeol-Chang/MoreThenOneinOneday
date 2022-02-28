import java.util.Arrays;
import java.util.Scanner;
public class BJ4153 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = new int[3];
        while(true) {
            nums[0] = in.nextInt();
            nums[1] = in.nextInt();
            nums[2] = in.nextInt();
            if(nums[0] == 0) break;

            Arrays.sort(nums);
            if(Math.pow(nums[0], 2) + Math.pow(nums[1], 2) == Math.pow(nums[2], 2)){
                System.out.println("right");
            }else System.out.println("wrong");
        }

        in.close();
    }

}