import java.util.Scanner;
public class CU1353 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < i + 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
