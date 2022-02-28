import java.util.Scanner;
public class BJ15829{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        final int r = 31;
        final int M = 1234567891;

        int l = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        in.close();
        
        //r의 제곱들을 저장할 변수.
        long[] rs = new long[l];
        rs[0] = 1;
        for(int i = 1; i < l; i++){
            long tmp = rs[i-1] * r;
            //System.out.print(i + " : " + tmp + ", ");
            while (tmp > M) tmp -= M;
            rs[i] = tmp;
            //System.out.println(rs[i]);
        }


        long sum = 0;

        for(int i = 0; i < l; i++){
            sum += ((int)str.charAt(i) - 96) * rs[i];
            while(sum > M) sum-= M;
        }
        sum %= M;
        System.out.println(sum);
        
    }
}