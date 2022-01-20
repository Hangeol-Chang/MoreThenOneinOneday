import java.util.Scanner;

public class CU1097 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        boolean[][] baduk = new boolean[20][20];
        
        for(int i = 1; i< 20; i++){
            for(int j = 1; j < 20; j++){
                baduk[i][j] = (in.nextInt() == 1) ? true : false;
            }
        }
        int n = in.nextInt();
        int[][] rev = new int[n][2];
        for(int i = 0; i < n; i++){
            rev[i][0] = in.nextInt();   //행
            rev[i][1] = in.nextInt();   //열
        }
        in.close();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < 20; j++){
                baduk[rev[i][0]][j] = !baduk[rev[i][0]][j];
                baduk[j][rev[i][1]] = !baduk[j][rev[i][1]];
            }
        }

        for(int i = 1; i < 20; i++){
            for(int j = 1; j < 20; j++){
                System.out.print(( baduk[i][j] )? 1 : 0);

                if(j == 19) System.out.printf("\n");
                else System.out.printf(" ");
            }
        }

    }
}
