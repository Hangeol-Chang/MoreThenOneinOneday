package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
 * 사실 정렬을 해줄 필요가 없는 문제였음.
 */
public class BJ16235_나무제태크 {
	static int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static class treeinfo implements Comparable<treeinfo> {
		int y, x, age;
		public treeinfo(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
		@Override
		public int compareTo(treeinfo o) {
			return age - o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<treeinfo> trees = new LinkedList<>();
		Queue<treeinfo> deadtree = new LinkedList<>();
		// 공간 크기
		int N = Integer.parseInt(st.nextToken());
		// 나무의 수
		int M = Integer.parseInt(st.nextToken());
		// 지나는 년
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int[][] add = new int[N][];
		// 초기 양분 5
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				map[i][j] = 5;
		
		// 겨울마다 추가될 양
		for(int i = 0; i < N; i++)
			add[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// 나무 위치 받기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			trees.add(new treeinfo(y, x, age));
		}
		
		/*
		 봄 : 나무가 자신의 나이만큼 양분을 먹음. 나이+1
		 		양분 못먹으면 디짐.
		 여름 : 죽은 나무가 양분으로 변함. 나무/2만큰 양분 증가.
		 가을 : 나이%5 == 0일 때, 인접한 8개 칸에 나이1 나무 생성.
		 겨울 : 양분을 줌.
		 */
		while(K > 0) {
			// 봄
			Iterator<treeinfo> iterator = trees.iterator();
			while(iterator.hasNext()) {
				treeinfo tree = iterator.next();
				if(map[tree.x][tree.y] >= tree.age) {
					map[tree.x][tree.y] -= tree.age;
					tree.age += 1;
				}
				else {
					iterator.remove();
					deadtree.add(tree);
				}
			}
			
			// 여름
			while(!deadtree.isEmpty()) {
				treeinfo tree = deadtree.poll();
				map[tree.x][tree.y] += tree.age /2;
			}
			
			// 가을
			LinkedList<treeinfo> tmptrees = new LinkedList<>();
			for(treeinfo tree : trees) {
				if(tree.age % 5 == 0) {
					for(int d = 0; d < 8; d++) {
						int ny = tree.y + dr[d];
						int nx = tree.x + dc[d];
						if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
							tmptrees.add(new treeinfo(ny, nx, 1));
						}
					}
				}
			}
			trees.addAll(0, tmptrees);
			
			// 겨울
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] += add[i][j];
				}
			}
			K--;
		}
		System.out.println(trees.size());
	}
}
