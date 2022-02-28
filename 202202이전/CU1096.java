import java.util.Scanner;

public class CU1096 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[][] baduk = new int[20][20];

        for(int i = 0; i < n; i++){
            baduk[in.nextInt()][in.nextInt()] = 1;
        }
        in.close();

        for(int i = 1; i < 20; i++){
            for(int j = 1; j < 20; j++){
                System.out.print(baduk[i][j]);
                if(j == 19) System.out.printf("\n");
                else System.out.printf(" ");
            }
        }
    }
}
