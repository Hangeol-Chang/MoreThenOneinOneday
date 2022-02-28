import java.util.Scanner;
public class CU1512_2 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                System.out.print( Math.abs(x - i) + Math.abs(y - j) + 1 + " ");
            }
            System.out.println();
        }
    }
}
