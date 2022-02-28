import java.util.Scanner;

public class CU1501 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%d ", i*n + j + 1);
            }
            System.out.printf("\n");
        }

    }
}