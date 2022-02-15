import java.util.Scanner;
import java.util.Arrays;

public class BJ1337 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) { nums[i] = in.nextInt(); }
        Arrays.sort(nums);

        int st = 0;
        int ed = 1;
        int min = 4;    //min중에 최대값.

        if(n == 1) {
            System.out.println(4);
        }else{
            while(st < n && ed < n) {
                int numcha = nums[ed] - nums[st];
                int idxcha = ed - st;
                
                int needed = numcha - idxcha;
                if(numcha < 4 && numcha >= idxcha) needed += (4-numcha);
                if(min > needed) min = needed;

                //idxcha가 4 이상이면, 무조건 numcha가 4이상이 되게 설정되어 있음.
                //(중복된 수가 없으므로).
                if(numcha >= 4 || ed == n-1) st++;
                if(idxcha < 4) ed++;
            }
            System.out.println(min);
        }
        in.close();
    }
}    
