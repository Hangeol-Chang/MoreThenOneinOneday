
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7236_저수지의물의총깊이구하기{
    static String[][] map;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());

            map = new String[n][];
            
            for(int i = 0; i < n; i++){ map[i] = br.readLine().split(" "); }

            //입력받기 끝.
            int maxdepth = 1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j].equals("W")){
                        maxdepth = Math.max(maxdepth, countw(i, j));
                        //System.out.println(maxdepth + ", r c : " + i + " " + j);
                    }
                }
            }
            sb.append("#" + t + " " + maxdepth + "\n");
        }
        System.out.println(sb);
    }
    public static int countw(int i, int j){
        int depth = 0;
        for(int d = 0; d < 8; d++){
            int nr = i + dr[d];
            int nc = j + dc[d];
            
            if(nc < 0 || nc >= n || nr < 0 || nr >= n) {continue; }
            if(map[nr][nc].equals("W")) depth++;
        }
        return depth;
    }
}