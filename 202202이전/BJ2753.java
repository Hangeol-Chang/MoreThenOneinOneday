import java.util.Scanner;

public class BJ2753 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        int a = input.nextInt();
        input.close();

        if (a % 4 == 0 ){
            if(a % 100 != 0 || a % 400 == 0) System.out.print(1);
            else System.out.print(0);
        }
        else System.out.print(0);
    }
}
