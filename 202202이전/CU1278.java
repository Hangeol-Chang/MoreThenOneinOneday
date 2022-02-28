import java.util.Scanner;
public class CU1278 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.close();

        int count = 1;
        while( true ) {
            t /= 10;
            if( t > 0 ) count++;
            else break;
        }
        System.out.println(count);
    }
}
