import java.util.Scanner;

public class BJ2884 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        String in2 = in.nextLine();
        String[] hm = in2.split(" ");
        in.close();
        
        int hh = Integer.parseInt(hm[0]);
        int mm = Integer.parseInt(hm[1]);
        
        if( mm < 45 ) {
            if( hh >= 1 ){
                hh -= 1;
            }
            else hh = 23;
            mm += 15;
        }
        else {
            mm -= 45;
        }
        System.out.println(hh + " " + mm);
    }
}
