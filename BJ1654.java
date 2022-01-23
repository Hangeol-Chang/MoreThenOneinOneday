//시간 초과
//틀렸습니다.

import java.util.Scanner;

public class BJ1654 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int goalnum = in.nextInt();
        int[] lan = new int[k];

        lan[0] = in.nextInt();
        int max = lan[0];
        int min = 0;
        for(int i = 1; i < k; i++){
            lan[i] = in.nextInt();
            if(lan[i] > max) max = lan[i];
        }
        in.close();
        
        int lannum = 0;
        int lanlength = (min + max) / 2;
        while(min + 1 < max){
            lannum = lannumcalc(k, lanlength, lan);
            
            if(lannum >= goalnum){
                min = lanlength;
            }else max = lanlength;

            //System.out.println(min + " " + max + " " + lanlength);
            lanlength = (min + max) / 2;

            //0.5가 버려지는 것 때문에, 넘겨지는 수가 발생함.
            //아닌가 딴건가...
        }
        System.out.println((lannumcalc(k, lanlength + 2, lan) == goalnum) ? lanlength + 2 : (lannumcalc(k, lanlength + 1, lan) == goalnum) ? lanlength + 1 : lanlength);
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