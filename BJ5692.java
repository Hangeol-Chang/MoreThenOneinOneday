import java.util.Scanner;

public class BJ5692 {
    public static int fact(int n){
        if(n == 1) return n;
        else return n * fact(n-1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(true){
            int num = in.nextInt();
            if(num == 0) break;
            int sum = 0;
            int i = 1;

            while(num > 0){
                sum += (num % 10) * fact(i);
                num /= 10;
                i++;
            }
            System.out.println(sum);
        }
        in.close();
    }
}
