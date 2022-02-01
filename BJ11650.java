import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class BJ11650 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();
        in.nextLine();
        int[][] nums = new int[n][2];

        for(int i = 0; i < n ; i++){
            String[] tmp = in.nextLine().split(" ");
            nums[i][0] = Integer.parseInt(tmp[0]);
            nums[i][1] = Integer.parseInt(tmp[1]);
        }
        in.close();

        Arrays.sort(nums, new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                if( n1[0] - n2[0] != 0 ) return n1[0] - n2[0];
                else return n1[1] - n2[1];
            }
        });
        
        for(int i = 0; i < n; i++){
            sb.append(nums[i][0]).append(" ").append(nums[i][1]).append("\n");
        }
        System.out.println(sb);

    }
}
