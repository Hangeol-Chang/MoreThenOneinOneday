package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 나보다 작거나 같은 물고기를 지나갈 수 있음.
 * 나보다 작은 물고기만 먹을 수 있음.
 * 
 * 현재 상황에서 가장 가까운 먹을 수 있는 물고기를 먹고,
 * 한 칸 이동에 1초가 소요됨.
 * 이동거리가 같으면, 왼쪽 위에 있는 놈부터 처리.
 * caneat 큐를 만들어서, 이번 턴에 먹을 수 있는 것들을 정리해서 넣어놓고,
 * 
 * 먹을 수 있으면 시간 출력.
 * 없으면 0 출력
 * 
 * 자기 머릿수만큼 먹으면 사이즈가 증가함.
 * 
 * 움직일 수 있는 모든 칸으로 bfs를 보내면서,
 * 물고기를 먹으면 그 위치로 초기화.
 * 
 */
public class BJ16236_아기상어 {
	static int N;
	static int[][] map;
	
	public static class shark {
		int y, x, size, eat;
		public shark(int y, int x) {
			this.y = y;
			this.x = x;
			size = 2;
			eat = 0;
		}
		
		public void eat() {
			eat++;
			if(size <= eat) {
				eat = 0;
				size++;
			}
		}
	}
	public static class loc implements Comparable<loc> {
		int y, x;
		public loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(loc o) {
			// TODO Auto-generated method stub
			if(this.y != o.y) {
				return this.y - o.y;
			}
			else {
				return this.x - this.y;
			}
		}
	}
	static int[] shark = new int[2];
	static TreeSet<loc> caneat = new TreeSet<>();
	static Queue<loc> sharkmove = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					map[i][j] = 0;
				}
			}
		}
		// 어케해야되냐
		
	}
	public static int pathfind(int[] start, int[] end, int dist, int[][] visit) {
		return 0;
	}
}
