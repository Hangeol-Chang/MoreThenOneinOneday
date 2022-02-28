import java.util.Scanner;
public class BJ11050 {
    public static int fact(int n){
        if(n == 1 || n == 0) return 1;
        else return n * fact(n-1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        in.close();

        System.out.println(fact(n) / (fact(k) * fact(n-k)));
    }
}
