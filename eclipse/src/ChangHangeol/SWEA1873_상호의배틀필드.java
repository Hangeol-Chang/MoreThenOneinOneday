package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA1873_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tankref = "^v<>";
		String dirref = "UDLR";
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int[] yx = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			char[][] board = new char[yx[0]][yx[1]];
			
			int tanky = 0;
			int tankx = 0;
			int dir = 0;
			for(int i = 0; i < yx[0]; i++) {
				String tmp = br.readLine();							//한줄씩 읽어오고
				for(int j = 0; j < yx[1]; j++) {
					board[i][j] = tmp.charAt(j);					//배열로 쪼개기
					//탱크의 위치, 방향 가져오기.
					if(tankref.indexOf(board[i][j]) >= 0) {
						tanky = i; tankx = j;
						dir = tankref.indexOf(board[i][j]);
					}
				}
			}
			int[] dy = {-1, 1, 0, 0};
			int[] dx = {0, 0, -1, 1};
			int nx = 0, ny = 0;
			
			int ordernum = Integer.parseInt(br.readLine());
			String orders = br.readLine();
			for(int or = 0; or < ordernum; or++) {
				switch(orders.charAt(or)) {
				case 'U' :
				case 'D' :
				case 'L' :
				case 'R' :	
					dir = dirref.indexOf(orders.charAt(or));
					board[tanky][tankx] = tankref.charAt(dir);
					ny = tanky + dy[dir];
					nx = tankx + dx[dir];
					if(nx >= 0 && nx < yx[1] && ny >= 0 && ny < yx[0] && board[ny][nx] == '.') {
						board[tanky][tankx] = '.';
						tanky = ny;
						tankx = nx;
						board[tanky][tankx] = tankref.charAt(dir);
					}
					break;
				case 'S' :
					int d = 1;
					와일 : while(true) {
						ny = tanky + dy[dir]*d;
						nx = tankx + dx[dir]*d;
						//범위 벗어나면 끝내기.
						if(nx < 0 || nx >= yx[1] || ny < 0 || ny >= yx[0]) break 와일;
						
						switch(board[ny][nx]) {
						case '.' :		//평지
						case '-' :		//물
							//평지나 물을 만나면, 계속 전진.
							d++;
							break;
						case '*' :		//벽벽
							board[ny][nx] = '.';
							break 와일;
						case '#' :		//강벽
							break 와일;
						}
					}
					break;
				}
			}
			for(int i = 0; i < yx[0]; i++) {
				for(int j = 0; j < yx[1]; j++) {
					sb.append(board[i][j]);					
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
