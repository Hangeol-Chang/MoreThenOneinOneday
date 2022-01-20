import java.util.Scanner;
public class CU1094 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] call = new int[n];
        for(int i = 0; i < n; i++){
            call[i] = in.nextInt();
        }
        in.close();

        for(int i = n-1; i > 0; i--) System.out.printf("%d ",call[i]);
        System.out.print(call[0]);
    }
}
