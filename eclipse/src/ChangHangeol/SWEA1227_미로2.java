package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1227_미로2 {
	static class loc {
		int y;
		int x;
		
		loc(int r, int c) {
			this.y = r;
			this.x = c;
		}
	}
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] map;
		// 테스트케이스 10개
		for(int t = 1; t <= 10; t++) {
			// 위치를 넣어놓을 스택 선언.
			Stack<loc> stk = new Stack<>();
			br.readLine();	//테케 번호 버리기
			map = new int[100][100];
			
			// 입력받기
			for(int i = 0; i < 100; i++) {
				String a = br.readLine();
				for(int j = 0; j < 100; j++) {
					// 입력받은 string에서 한자리씩 불러오면서, 0을 빼줌.
					map[i][j] = a.charAt(j) - '0';
					if(map[i][j] == 2) {stk.add(new loc(i, j));}
				}
			}
			// 입력받기 끝.
			
			// 도달했는지 확인할 변수.
			boolean cango = false;
			while( !stk.isEmpty() ) {
				// 스택에서 계산할 위치 꺼내오기
				loc nowloc = stk.pop();
				// 현재 위치 값이 3이면, 도착한 것이므로 브레이크
				if(map[nowloc.y][nowloc.x] == 3) {
					cango = true;
					break;
				}
				
				// 지금 위치 벽으로 만들기
				map[nowloc.y][nowloc.x] = 1;
				
				for(int d = 0; d < 4; d++) {
					int ny = nowloc.y + dy[d];
					int nx = nowloc.x + dx[d];
					// 4방향에 대해, 벽이 아닌 곳들 전부 스택에 넣음.
					if(map[ny][nx] != 1) stk.add(new loc(ny, nx));
				}
			}
			sb.append("#" + t + " " + (cango ? 1 : 0) + "\n");
		}
		System.out.println(sb);
	}
}
