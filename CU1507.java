import java.util.Scanner;
public class CU1507 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int[][] arr = new int[4][4];
        for(int i = 0; i < 4;i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();

        //최대위치구하기
        int maxx = arr[0][2];
        int maxy = arr[0][3];
        for(int i = 0; i < 4; i++){
            if(maxx < arr[i][2]) maxx = arr[i][2];
            if(maxy < arr[i][3]) maxy = arr[i][3];
        }

        //판 칠하기
        int[][] board = new int[maxx + 1][maxy + 1];
        for(int p = 0; p < 4; p++)
            for(int i = arr[p][0]; i < arr[p][2]; i++) 
                for(int j = arr[p][1]; j < arr[p][3]; j++ )
                    board[i][j] = 1;

        int count = 0;
        
        for(int i = 1; i < maxx + 1; i++){
            for(int j = 1; j < maxy + 1; j++){
                //System.out.printf("%d ", board[i][j]);
                if(board[i][j] == 1) count++;
            }
            //System.out.println();
        }
        
        System.out.println(count);
    }
}
