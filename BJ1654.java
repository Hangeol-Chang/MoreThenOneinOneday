//시간 초과
//틀렸습니다.
//교수님한테 long 함수로 넘기는거 물어볼 것.

import java.util.Scanner;

public class BJ1654 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int goalnum = in.nextInt();
        int[] lan = new int[k];

        lan[0] = in.nextInt();
        long max = lan[0];
        long min = 0;
        for(int i = 1; i < k; i++){
            lan[i] = in.nextInt();
            if(lan[i] > max) max = lan[i];
        }
        in.close();
        
        int lannum = 0;
        long lanlength = 0;
        
        while(min +1 < max){
            lanlength = ((min + max +1) / 2);
            
            lannum = 0;
            for(int i = 0; i < k; i++) {
                lannum += lan[i] / lanlength; 
            }
            
            if(lannum >= goalnum){
                min = lanlength;
            }else max = lanlength;

            //System.out.println(min + " " + max + " " + lanlength);
        }

        System.out.println("??");
        while( lannum == goalnum )
            lanlength++;
            System.out.println(lanlength + " " + lannum);
            lannum = 0;
            for(int i = 0; i < k; i++) {
                lannum += lan[i] / lanlength; 
        }
        System.out.println(--lanlength);
    }
}