/*
2는 졸라 많으니까
5가 나올때마다 1씩 늠.
5로 나눈 몫이 0이 될때까지 나눠서 더하면 그게 답이지 않을까?
*/
import java.util.Scanner;

public class BJ1676 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int sum = 0; 
        while(n > 0){
            n /= 5;
            sum += n;
        }
        System.out.println(sum);
        in.close();
    }

}
