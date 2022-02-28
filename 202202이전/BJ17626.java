import java.util.Scanner;
public class BJ17626 {

    //count n을 돌려주는 함수
    // public static int rooting(int n){
    //     if(n == 0) return 0;
    //     else if(count[n] != 0 ) return count[n];
    //     else {
    //         int njj;
    //         int min = 3;
    //         int t = 0;
    //         do {
    //             //n이랑 가까운 제곱값
    //             int pownum = (int)Math.pow((int)Math.sqrt(n) - t, 2);
    //             njj = n - pownum;

    //             int tmp = rooting(njj);

    //             if( tmp < min ) min = tmp;
    //             t++;

    //         } while(njj > 1);

    //         count[n] = 1 + min;
    //         return count[n];
    //     }
    // }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int pownum = (int)Math.sqrt(i);
            int min = 3;

            for(int t = 0 ; t < pownum; t++){

                int tmp = count[i - (int)Math.pow(pownum - t, 2)];
                if( tmp < min ) min = tmp;
            }
            
            count[i] = 1 + min;
        }

        //rooting(n);
        // System.out.println(rooting(n));
        System.out.println(count[n]);
        in.close();
    }
    
}
