package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1927_최소힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 힙의 크기
		int size = 0;
		// 힙배열은 연산의 개수보다 클 수가 없다 생각하여 N+1로 크기설정
		int[] heap = new int[N + 1];
		// 연산 수행
		for (int i = 0; i < N; i++) {
			// 명령어
			int cmd = Integer.parseInt(br.readLine());
			// 현재 노드를 가리키는 변수
			int node = 0;
			// 삽입일 때
			if (cmd != 0) {
				node = ++size;
				// 현재 노드에 데이터 넣기
				heap[node] = cmd;
				// 현재 노드가 1보다 크고 자식들보다 클 때까지 반복하면서 정렬하기
				while (node > 1 && heap[node] < heap[node / 2]) {
					// 반복문을 들어왔다는건 자식이 더 큰거기 때문에 자식과 부모 노드 위치 바꿔주기
					int tmp = heap[node];
					heap[node] = heap[node / 2];
					heap[node / 2] = tmp;
					// 현재노드를 부모로 계속 바꾸기
					node = node / 2;
				}
				// 삭제
			} else {
				// 루트노트부터 시작
				node = 1;
				// 사이즈가 0이라는건 노드가 없다는 것
				if (size == 0)
					System.out.println(0);
				else {
					System.out.println(heap[node]);
					// 루트노드에 마지막 노드값 넣고 사이즈 줄이기
					heap[node] = heap[size--];
					for (;;) {
						// 왼쪽 자식노드 변수
						int childNode = node * 2;
						// 왼쪽 오른쪽 자식 중에 뭐가 더큰지 판별해서 자식노드값 바꿔주기 단, 사이즈보다 더 크지 않도록
						if (childNode + 1 <= size && heap[childNode + 1] < heap[childNode])
							childNode++;
						// 자식노드가 사이즈보다 크거나 부모노드가 자식노드보다 크게 되었다면 반복문 탈출
						if (childNode > size || heap[node] < heap[childNode])
							break;

						// 자식 노드가 더크다면 위치 바꿔주기
						int tmp = heap[node];
						heap[node] = heap[childNode];
						heap[childNode] = tmp;
						// 현재 노드를 자식노드로 업데이트 해서 계속 반복
						node = childNode;
					}
				}
			}
		}
	}

}
