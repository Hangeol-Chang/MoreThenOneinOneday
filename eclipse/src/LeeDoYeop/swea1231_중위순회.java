package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1231_중위순회 {
	static char[] treeV;
	static int[][] treeLR;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			// 해당 노드의 알파벳 
			treeV = new char[N + 1];
			// 해당 노드의 자식들
			treeLR = new int[N + 1][2];
			// 입력받기
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken());
				char vertex = st.nextToken().charAt(0);
				int left = 0;
				int right = 0;
				// 정점의 총 수보다 자식노드의 정점번호가 작거나 같을때만 입력받기.
				if (idx * 2 <= N)
					left = Integer.parseInt(st.nextToken());
				if (idx * 2 + 1 <= N)
					right = Integer.parseInt(st.nextToken());
				// 각 배열에 넣어주기
				treeV[idx] = vertex;
				treeLR[idx][0] = left;
				treeLR[idx][1] = right;
			}
			sb.append("#").append(tc).append(" ");
			// 0번은 비워놨으니 1번부터
			inOrder(1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 중위 순회 LVR
	public static void inOrder(int i) {
		// 자식이 없다면 순회는 안하고 위로 돌아가야 하고 방문처리
		if (treeLR[i][0] == 0 && treeLR[i][1] == 0) {
			sb.append(treeV[i]);
		} else {
			// 왼쪽 자식이 있다면 다시 순회하기
			if (treeLR[i][0] != 0) {
				//재귀
				inOrder(treeLR[i][0]);
			}
			// 왼쪽 자식을 모두 다 거쳤다면 정점으로 가니까 출력
			sb.append(treeV[i]);
			// 오른쪽 순회하기
			if (treeLR[i][1] != 0) {
				//재귀
				inOrder(treeLR[i][1]);
			}
		}
	}
}
