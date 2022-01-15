import java.util.Scanner;
public class BJ10818 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        String[] nums = in.nextLine().split(" ");
        
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);
        for(int i = 1; i < t; i++){
            int lib = Integer.parseInt(nums[i]);
            if(max < lib) max = lib;
            else if(lib < min) min = lib;
        }
        System.out.print(min + " " + max);
        in.close();
    }
}