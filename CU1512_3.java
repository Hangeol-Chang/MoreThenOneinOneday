import java.util.Scanner;
public class CU1512_3 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        
        int[][] board = new int[n+1][n+1];

        for(int i = x; i > 0; i--)    board[i][y] = x - i + 1;
        for(int i = x; i < n +1; i++) board[i][y] = i - x + 1;

        for(int i = 1; i < n+1; i++){
            for(int j = y; j > 0; j--){
                board[i][j] = board[i][y] + y - j;
            }
            for(int j = y; j < n+1; j++){
                board[i][j] = board[i][y] + j - y;
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                System.out.print( board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
