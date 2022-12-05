

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로찾기_희정누나 {
    static class Pos {
        int r;
        int c;
        int dist;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        } // 입력 완

        
//        int dist=0;
        int ansDist = 987654321;
        
        Pos start = new Pos(0, 0, 1);

        boolean[][] visited = new boolean[n][m];

        // 큐 생성
        Queue<Pos> q = new LinkedList<>();

        visited[start.r][start.c] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Pos curr = q.poll();

            if (curr.r == n-1 && curr.c == m-1) {
                    ansDist = curr.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (maze[nr][nc] != '1' || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                q.add(new Pos(nr, nc, curr.dist+1));
            } // 4방향 탐색
        } // bfs while

        System.out.println(ansDist);
    }// main

}

/*

2 20
10111011101110111111
11101110111011101111


*/