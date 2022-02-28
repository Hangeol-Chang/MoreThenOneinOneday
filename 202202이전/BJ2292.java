import java.util.Scanner;
public class BJ2292 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int i = 1;
        int sum = i;
        int tmp = 1;

        while(tmp < n){
            tmp = 6 * sum + 1;
            sum += ++i;
        }
        System.out.println(i);
    }

}
/*
1
7       6 * 1 + 1               2   
19      6 * 3 + 1               3
37      6 * 6 + 1               4
61      6 * 10 + 1              5

15
21

n(n+1)/2 = a

*/