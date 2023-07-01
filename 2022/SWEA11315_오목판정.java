
import java.util.Scanner;

public class SWEA11315_오목판정 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            int n = in.nextInt();
            in.nextLine();
            char[][] board = new char[n][];
            
            for(int i = 0; i < n; i++) {
                board[i] = in.nextLine().toCharArray();
            }
            //입력받기 끝.
            
            int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
            
            boolean yes = false;
            포 : for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    델타포 : for(int d = 0; d < 8; d++){
                        int count = 0;
                        int delta = 0;
                        while(count < 5){
                            int nr = i + delta*dr[d];
                            int nc = j + delta*dc[d];
                            
                            if(nr < 0 || nc < 0 || nr >= n || nc >= n){
                                continue 델타포;
                            }
                            if(board[nr][nc] == 'o') { count++; delta++; }
                            else continue 델타포;
                        }
                        if(count == 5){
                            yes = true;
                            break 포;
                        }
                    }
                }
            }
            sb.append("#" + t + " ");
            if(yes) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
        in.close();
    }
}
/*
1
6
o.....
.o...o
..o..o
.....o
....oo
.....o
*/
