import java.util.Scanner;
public class CU1355 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();

        for(int i = n; i > 0; i--){
            for(int j = 0; j < n - i; j++) System.out.print(" ");
            for(int j = 1; j < i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
