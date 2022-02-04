import java.util.Scanner;
public class BJ10816{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[20000001];        
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            nums[in.nextInt() + 10000000]++;
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i++){
            sb.append(nums[in.nextInt()+10000000]).append(' ');
        }
        in.close();
        System.out.println(sb);
        
    }
}