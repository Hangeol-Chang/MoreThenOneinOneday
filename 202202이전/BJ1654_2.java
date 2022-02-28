import java.util.Scanner;
public class BJ1654_2 {
    public static int function(int k, long lanlength, int[] lan){
        int lannum = 0;
        for(int i = 0; i < k; i++) lannum += lan[i] / lanlength;
        return lannum;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int k = in.nextInt();
        int lancount_goal = in.nextInt();
        int[] lan = new int[k];

        long max = 0;
        long min = 0;
        for(int i = 0; i < k; i++){
            lan[i] = in.nextInt();
            if(lan[i] > max) max = lan[i];
        }
        in.close();
        max++;

        int lancount = 0;
        long lanlength = (max + min) / 2;

        lanlength = (int)((min + max) / 2 + 1);
        do {
            lancount = function(k, lanlength, lan);

            if(lancount >= lancount_goal) min = lanlength + 1;
            else max = lanlength;

            lanlength = (int)((min + max) / 2);
        } while(min < max);

        System.out.println(--min);
    }
}
/*
4 11
802
743
457
539
*/