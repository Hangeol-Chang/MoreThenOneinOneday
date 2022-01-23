//시간 초과

import java.util.Scanner;
public class BJ1654 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int goalnum = in.nextInt();
        int sum = 0;
        int[] lan = new int[k];

        for(int i = 0; i < k; i++){
            lan[i] = in.nextInt();
            sum += lan[i];
        }
        in.close();

        //System.out.println(sum);
        //System.out.println();

        int lanlength = sum / goalnum;
        int max = lanlength;
        int min = 0;
        int lannum = 0;

        while(true){
            //System.out.println(lanlength);

            lannum = lannumcalc(k, lanlength, lan);

            if(lannum > goalnum) {
                min = lanlength;
                lanlength += (max - lanlength)/2;
            } else if(lannum < goalnum) {
                max = lanlength;
                lanlength -= (lanlength - min)/2;
            } else {
                break;
            }
        }
        lanlength = max;
        do {
            lanlength--;
            lannum = lannumcalc(k, lanlength, lan);
            //System.out.println(lannum + " " + goalnum);
        } while(lannum < goalnum);

        System.out.println(lanlength);
    }

    public static int lannumcalc(int k, int lanlength, int[] lan){
        int lannum = 0;
        for(int i = 0; i < k; i++) lannum += lan[i] / lanlength; 
        return lannum;
    }
}
/**
 * 231
 * 115
 * 173
 * 201
 * 
 *  */