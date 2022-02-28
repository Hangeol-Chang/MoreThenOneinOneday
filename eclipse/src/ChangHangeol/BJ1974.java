package ChangHangeol;
import java.util.Scanner;
import java.util.stream.Stream;

public class BJ1974{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = in.nextInt();
        in.nextLine();

        int[][] sudoku = new int[9][];
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            //입력받기
            for(int i = 0; i < 9; i++){
                sudoku[i] = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[] dr = {0,1};
            int[] dc = {1,0};

            //숫자가 홀수개이므로, 전부 false로 돌아올 수 없음.
            boolean pass = true;
            outer : for(int i = 0; i < 9; i++){
                boolean[] check ;
                //가로세로 확인.
                for(int d = 0; d < 2; d++){
                    check = new boolean[9];
                    for(int j = 0; j < 9; j++) {
                        int nr = i * dc[d] + j * dr[d];
                        int nc = i * dr[d] + j * dc[d];
                        //System.out.println("열 : " + nr + ", 행 : " + nc);
                        check[sudoku[nr][nc]-1] = !check[sudoku[nr][nc]-1];
                    }
                    for(int fi = 0; fi < 9; fi++){
                        if(!check[fi]) { pass = false;  break outer; }
                    }
                }

                //시작위치
                // [(i/3)*3][(i%3)*3]
                //인덱싱위치
                // [ + j/3][ + j%3]
                //박스확인
                check = new boolean[9];
                for(int j = 0; j < 9; j++) {
                    int nr = (i/3)*3 + j/3;
                    int nc = (i%3)*3 + j%3;
                    check[sudoku[nr][nc]-1] = !check[sudoku[nr][nc]-1];
                }
                for(int fi = 0; fi < 9; fi++){
                    if(!check[fi]) { pass = false;  break outer; }
                }
            }

            sb.append(pass ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}