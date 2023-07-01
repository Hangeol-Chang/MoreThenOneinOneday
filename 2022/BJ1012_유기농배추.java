
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 하나씩 다 찾으면서,
 * 인접해 있는 걸 
 */
public class BJ1012_유기농배추 {
    static int[][] baechu;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int X;
    static int Y;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            baechu = new int[X][Y];

            for(int i = 0; i < o; i++){
                st = new StringTokenizer(br.readLine());
                int tmpx = Integer.parseInt(st.nextToken());
                int tmpy = Integer.parseInt(st.nextToken());
                baechu[tmpx][tmpy] = 1;
            }
            //입력받기 끝.
            // for(int j = 0; j < Y; j++){
            //     for(int i = 0; i < X; i++){
            //         System.out.print(baechu[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            int count = 0;
            for(int nx = 0; nx < X; nx++){
                for(int ny = 0; ny < Y; ny++){
                    if(baechu[nx][ny] == 1){
                        count++;
                        baechu[nx][ny] = 0;
                        erase(nx, ny);

                        // for(int j = 0; j < Y; j++){
                        //     for(int i = 0; i < X; i++){
                        //         System.out.print(baechu[i][j] + " ");
                        //     }
                        //     System.out.println();
                        // }
                        // System.out.println();
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
    public static void erase(int x, int y){
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // System.out.println(x + " " + y + " " + nx + " " + ny);
            if(nx >= 0 && nx < X && ny >= 0 && ny < Y && baechu[nx][ny] == 1) {
                baechu[nx][ny] = 0;
                erase(nx, ny);
            }
        }
        return;
    }
}
