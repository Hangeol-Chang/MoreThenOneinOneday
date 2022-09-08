import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1025_제곱수찾기 {
    
    static int[][] map;
    static int N, M;
    static long ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String vanilla = br.readLine();
            for(int j = 0; j < M; j++)
                map[i][j] = vanilla.charAt(j) - '0';
        }
        // 입력 완료.

        // 판단 시작 위치 r, c
        // 0에 닿는 위치부터 N, M에 닿는 위치까지 진행.
        for(int r = 0; r < N; r++) {
            int fillett = 0 - r;
            int filletb = N - r;

            for(int c = 0; c < M; c++) {
                int filletl = 0 - c;
                int filletr = M - c;

                for(int i = fillett; i < filletb; i++) {
                    for(int j = filletl; j < filletr; j++) {
                        // 실 계산.
                        long num = 0;

                        int nr = r;
                        int nc = c;

                        if(i != 0 || j != 0) {
                            while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                                num = num*10 + map[nr][nc];

                                nr += i;
                                nc += j;
                                judge(num);
                            }
                        }
                        else num = (long)map[r][c];

                        judge(num);
                    }
                }
            }
        }
        System.out.print(ans);
        // System.out.println("ans " + ans);
    }

    static void judge(long num) {
        // System.out.println(num);

        long sqnum = (long)Math.sqrt(num);
        long newnum = sqnum*sqnum;
        if(newnum == num)
            ans = Math.max(ans, num);
    }
}
/*

2 3
123
456

 */