import java.util.Scanner;

public class BJ2438 {
     public static void main(String args[]){
         Scanner in = new Scanner(System.in);

         int n = in.nextInt();
         in.close();

         for(int i = 1; i <= n; i++){
             for(int j = 1; j < i+1 ; j++) System.out.print('*');
            System.out.println();
            }
     }
}
