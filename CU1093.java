import java.util.Scanner;
public class CU1093 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] called = new int[24];
        
        for(int i = 0; i < n; i++){
            called[in.nextInt()] ++;
        }
        in.close();
        
        for(int i = 1; i < 23; i++) System.out.printf("%d ", called[i]);
        System.out.print(called[23]);

    }
}