import java.util.Scanner;

public class BJ2739 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int ii = in.nextInt();
        in.close();

        for (int i = 1; i < 10; i++){
            System.out.println(ii + " * " + i + " = " + i * ii);
        }
    }
}