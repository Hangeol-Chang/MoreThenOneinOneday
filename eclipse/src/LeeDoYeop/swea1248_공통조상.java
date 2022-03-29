package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea1248_공통조상 {
	static int[][] tree;
	// 서브트리의 크기를 구할 변수
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			//서브트리의 크기 초기화
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());	// 트리의 정점의 총 수
			int E = Integer.parseInt(st.nextToken());	// 트리의 간선의 총 수
			int aNode = Integer.parseInt(st.nextToken()); 	// 공통조상 찾을 첫번째 정점
			int bNode = Integer.parseInt(st.nextToken());	// 공통조상 찾을 두번째 정점
			tree = new int[V + 1][2];
			st = new StringTokenizer(br.readLine(), " ");
			// 트리만들기
			for (int i = 1; i <= E; i++) {
				int vertex = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				// 첫번째 자식에 값을 안넣었다면 첫번째에 넣기
				if (tree[vertex][0] == 0)
					tree[vertex][0] = child;
				else
					tree[vertex][1] = child;
			}
			// 공통조상을 찾을 첫번째 정점이 루트까지 가는데 지나간 정점배열
			int[] aEdge = new int[V + 1];
			// 공통조상을 찾을 두번째 정점이 루트까지 가는데 지나간 정점배열
			int[] bEdge = new int[V + 1];
			aEdge[0] = aNode;
			bEdge[0] = bNode;
			int aIdx = 1;
			int bIdx = 1;
			// 공통 조상 중 가장 가까운 것의 번호
			int nearV = 0;
			// 루트까지 가기
			for (;;) {
				for (int j = 1; j <= V; j++) {
					// a정점을 루트까지 보내기
					if (tree[j][0] == aNode || tree[j][1] == aNode) {
						aEdge[aIdx++] = j;
						aNode = j;
					}
					// b정점을 루트까지 보내기
					if (tree[j][0] == bNode || tree[j][1] == bNode) {
						bEdge[bIdx++] = j;
						bNode = j;
					}
				}
				// 두 정점 모두 루트에 갔다면 break;
				if (aNode == 1 && bNode == 1)
					break;
			}
			
			// 공통 조상 찾기
			outer: for (int i = 0; i <= V; i++) {
				for (int j = 0; j <= V; j++) {
					// 공통 조상을 구했다면 바로 반복문 탈출하면 가장 가까운 것임 왜냐 밑에서 올라간 것이라서.
					if (aEdge[i] == bEdge[j]) {
						nearV = aEdge[i];
						break outer;
					}
					// 배열이 루트까지 갔다면 탈출 
					if(bEdge[j] == 1)
						break;
				}
			}
			//다른 문제에서 중위순회를 하는 것을 구했기 때문에 공통조상에서 중위순회를 해보면서 서브트리의 크기 구하기
			inOrder(nearV);
			sb.append("#").append(tc).append(" ").append(nearV).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//중위순회 처리
	public static void inOrder(int i) {
		// 자식이 없다면 순회는 안하고 위로 돌아가야 하고 방문처리
		if (tree[i][0] == 0 && tree[i][1] == 0) {
			// 순회했다면 갯수추가
			cnt++;
		} else {
			// 왼쪽 자식이 있다면 다시 순회하기
			if (tree[i][0] != 0) {
				//재귀
				inOrder(tree[i][0]);
			}
			// 순회했다면 갯수추가
			cnt++;
			// 오른쪽 순회하기
			if (tree[i][1] != 0) {
				//재귀
				inOrder(tree[i][1]);
			}
		}
	}
}
