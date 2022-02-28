import java.util.Scanner;
public class CU1512 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] board = new int[n+1][n+1];

        int x = in.nextInt();
        int y = in.nextInt();
        in.close();

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                board[i][j] = Math.abs(x - i) + Math.abs(y - j) + 1;
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
