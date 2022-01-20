import java.util.Scanner;

public class CU1492 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1; i < n+1; i++){
            nums[i] = in.nextInt() + nums[i-1];
        }
        in.close();
        
        for(int i = 1; i < n+1; i++) System.out.printf("%d ", nums[i]);
    }
}
