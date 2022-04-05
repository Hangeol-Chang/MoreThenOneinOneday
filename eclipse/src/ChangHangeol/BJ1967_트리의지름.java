package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1967_트리의지름 {
	static class node implements Comparable<node> {
		int v, w;
		node(int v, int w) {this.v = v; this.w = w;}
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1에서 시작해서 왼쪽 끝, 오른쪽 끝 위치 재기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<node>[] tree = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) tree[i] = new ArrayList<>();
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());				
			tree[Integer.parseInt(st.nextToken())].add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); 
		}
		// 입력받기 끝.
		
		
	}
	// 모든 말단 노드들에서 
	public void 
}
