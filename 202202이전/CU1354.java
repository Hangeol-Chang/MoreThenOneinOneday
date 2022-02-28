import java.util.Scanner;
public class CU1354 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();

        for(int i = n; i > 0; i--){
            for(int j = 1; j < i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
