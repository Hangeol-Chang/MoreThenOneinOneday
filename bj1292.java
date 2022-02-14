/*
1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
1 3 6 10 15
*/

import java.util.Scanner;
public class bj1292 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int start = in.nextInt();
        int end = in.nextInt();

        int tmp = 0;
        int startnum = 1;
        while(tmp < start) {
            tmp += startnum++;
        }
        //System.out.println(tmp);
        startnum--;

        int sum = 0;
        for(int i = start; i <= end; i++){
            if( i <= tmp ) sum += startnum; 
            else{
                tmp += ++startnum;
                sum += startnum;
            }
            //System.out.println("tmp : " + tmp + ", 현재 합계 : " + sum + ", sn : " + startnum);
        }
        System.out.println(sum);
        in.close();
    }
}
