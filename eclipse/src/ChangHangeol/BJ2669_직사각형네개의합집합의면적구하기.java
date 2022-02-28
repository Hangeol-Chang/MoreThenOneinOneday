package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 다 받고 시작.
		//입력을 받으면서, 칠해야 할 최대 위치가 어딘지 판단.
		int maxx = 0, maxy = 0;
		int[][][] boxes = new int[2][2][4];
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//시작좌표
			boxes[0][0][i] = Integer.parseInt(st.nextToken());
			boxes[0][1][i] = Integer.parseInt(st.nextToken());
			//끝좌표
			boxes[1][0][i] = Integer.parseInt(st.nextToken());
			boxes[1][1][i] = Integer.parseInt(st.nextToken());
			if(maxx < boxes[1][0][i]) maxx = boxes[1][0][i];
			if(maxy < boxes[1][1][i]) maxy = boxes[1][1][i];
		}
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0 ; j < 2; j++) {
//				System.out.println(boxes[j][0][i] + " " + boxes[j][1][i]);
//			}
//			System.out.println();
//		}
		
		//보드를 불리언으로 선언.
		//칠해지면 true로 바꾸고, 넓이에 1을 더하는 방식.
		//앞에서 구한 최대 위치만큼만 배열을 선언.
		boolean[][] board = new boolean[maxx][maxy];
		int nerbi = 0; //넓이
		for(int i = 0; i < 4; i++) {
			for(int x = boxes[0][0][i]; x < boxes[1][0][i]; x++) {
				for(int y = boxes[0][1][i]; y < boxes[1][1][i]; y++) {
					if(!board[x][y]) { board[x][y] = true; nerbi++; }
				}
			}
		}
//		for(int a = 0; a < maxx; a++) {
//			for(int j = 0; j < maxy; j++) {
//				System.out.print((board[a][j] ? 1 : 0) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		System.out.println(nerbi);
	}
}
