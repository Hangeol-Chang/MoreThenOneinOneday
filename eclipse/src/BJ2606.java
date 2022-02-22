import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2606 {
	static int count = 0;
	static int n = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n+1][n+1];
		boolean[] virused = new boolean[n+1];
		virused[1] = true;
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		////그래프 생성 끝.
		
		//검색할건데, j가 i보다 큰 범위에서만 검색.
		check(graph, virused, 1);
		System.out.println(count);
	}
	
	public static void check(int[][] graph, boolean[] virused, int index) {
		for(int i = 1; i< n+1; i++) graph[i][index] = 0;
		for(int j = 1; j < n+1; j++) {
			if(graph[index][j] == 1) {
				//System.out.println(index + " " + j);
				virused[j] = true;
				count++;
				check(graph, virused, j);
			}
		}
	}
}
