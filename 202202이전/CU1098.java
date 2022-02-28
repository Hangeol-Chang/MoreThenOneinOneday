import java.util.Scanner;
public class CU1098 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int xsize = in.nextInt() + 1;
        int ysize = in.nextInt() + 1;
        int[][] board = new int[xsize][ysize];

        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            int l = in.nextInt();
            int dir = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            
            for(int j = 0; j < l; j++){
                board[x + dir * j][y + (1 - dir) * j] = 1;
            }
        }
        in.close();
        
        for(int i = 1; i < xsize; i++){
            for(int j = 1; j < ysize; j++){
                System.out.print(board[i][j]);

                if(j == ysize - 1) System.out.printf("\n");
                else System.out.printf(" ");
            }
        }
    }
}
