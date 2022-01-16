import java.util.Scanner;

public class BJ1018 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String[] chess_tmp = new String[n];
        char[][] chess_c = new char[n][m];

        for (int i = 0; i < n; i++){
            chess_tmp[i] = in.nextLine();

            for (int j = 0; j < m; j++){
                chess_c[i][j] = chess_tmp[i].charAt(j);
            }
        }
        in.close();
        
        int[][] chess = new int[n][m];
        //0,0을 W로 해서 계산
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                switch ((i + j) % 2) {
                    case 0:
                        if(chess_c[i][j] == 'W') chess[i][j] = 0;
                        else                     chess[i][j] = 1;
                        break;
                    case 1:
                        if(chess_c[i][j] == 'B') chess[i][j] = 0;
                        else                     chess[i][j] = 1;
                        break;
                }
            }
        }

        int min = 64;

    }
}

/*
[0,0][0,1][0,2][0,3]
[1,0][1,1][1,2][1,3]
행열 수 합 홀짝으로 구분
*/