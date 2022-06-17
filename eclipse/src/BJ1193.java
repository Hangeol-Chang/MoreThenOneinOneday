

import java.util.Scanner;

public class BJ1193 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int t = 0;
        int i = 0;
        while(t < n){
        	t += ++i;
        }
        t -= i;
        if(i%2 == 1) System.out.println(i+1-(n-t) + "/"+ (n-t));
        else System.out.println((n-t) + "/" + (i+1-(n-t)));
        in.close();
    }
}
