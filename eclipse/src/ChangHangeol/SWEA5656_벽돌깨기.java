package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기{
	static int mincount = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static int H;
    static int W;
    
	
    public static void main(String[] args) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[H][W];
            int count = 0;
            for(int i = 0; i < H; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < W; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            		if(map[i][j] != 0) count++;
            	}
            }
            // 입력받기 끝.
            mincount = count;
            boom(N, map, count);
            
            sb.append("#" + t + " " + mincount +  "\n");
        }
        System.out.println(sb);
    }
    
    public static void boom(int n, int[][] map, int count){
    	class location {
    		// 폭발하는 위치를 저장하는 클래스.
    		int y;
    		int x;
    		int size;
    		public location(int y, int x, int size) {
    			this.y = y;
    			this.x = x;
    			this.size = size;
    		}
    	}
    	
    	// 가로로 지나가면서 폭탄을 다 떨궈봄.
        for(int j = 0; j < W; j++) {
        	Queue<location> que = new LinkedList<>();
        	// 깊은 복사로 배열을 새로 가져옴.
        	int[][] newmap = new int[H][W];
        	for(int y = 0; y < H; y++)
        		for(int x = 0; x < W; x++)
        			newmap[y][x] = map[y][x];
        	
        	// 폭탄이 터질 벽돌 위치를 가져옴.
        	int i = 0;
        	while(i < H && newmap[i][j] == 0) i++;
        	if(i >= H) continue;
        	
        	que.add(new location(i, j, newmap[i][j]));
        	newmap[i][j] = 0;
        	int newcount = count-1;
        	
        	// 폭탄 터뜨리기.
        	while(!que.isEmpty()) {
        		location loc = que.poll();
        		for(int s = 1; s < loc.size; s++) {
        			for(int d = 0; d < 4; d++) {
        				int ny = loc.y + s*dy[d];
        				int nx = loc.x + s*dx[d];
        				if(ny >= 0 && ny < H && nx >= 0 && nx < W) {
        					if(newmap[ny][nx] != 0) {
        						que.add(new location(ny, nx, newmap[ny][nx]));
        						newmap[ny][nx] = 0;
        						newcount--;
        					}
        				}
        			}
        		}
        	}
        	// 폭탄 터뜨리기 끝.
        	
        	// 배열 밑으로 땡기기.
        	for(int jj = 0; jj < W; jj++) {
        		int seti = H-1;
        		while(seti >= 0 && newmap[seti][jj] != 0) {
        			seti--;
        		}
        		for(int searchi = seti-1; searchi >= 0; searchi--) {
        			if(newmap[searchi][jj] != 0) {
        				newmap[seti--][jj] = newmap[searchi][jj];
        				newmap[searchi][jj] = 0;
        			}
        		}
        	}
        	
        	// j번 위치에 폭탄을 떨어뜨리고 저장.
        	// 디버그 코드
//        	System.out.println((n-1) + "번 폭발 남음, 터뜨린 위치 : " + j + ", 남은 벽돌 수  : " + newcount + ", 최소는 :" + mincount );
//        	for(int di = 0; di< H; di++) {
//        		for(int dj = 0; dj < W; dj++) {
//        			System.out.print(newmap[di][dj] + " ");
//        		}
//        		System.out.println();
//        	}
//        	System.out.println();
        	
        	if(n > 1) boom(n-1, newmap, newcount);
        	mincount = Math.min(mincount, newcount);
        }
    }
}

/*

1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1

1
2 4 4
0 0 0 0
1 0 0 0
2 1 1 3
1 1 1 4

1
4 12 15
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9 9 9 9 9
*/
