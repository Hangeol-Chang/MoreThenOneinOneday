import java.util.Scanner;

public class TESTIM {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for(int t = 1 ; t <= T; t++){

            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();

            double h = 1/6.0 * (x+y - Math.sqrt(x*x + y*y - x*y));
            double a = x - 2*h;
            double b = y - 2*h;
            
            System.out.printf("#%d %.6f\n", t, a*b*h);
        }
        in.close();
    }
}