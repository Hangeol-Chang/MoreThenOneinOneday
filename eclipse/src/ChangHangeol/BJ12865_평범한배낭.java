package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 다시 풀어볼 것.

public class BJ12865_평범한배낭 {
	static class node implements Comparable<node> {
		// 무게, 가치
		int w, v;
		node(int w, int v){ this.w = w; this.v = v; }
		// 무게순 정렬
		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<node> products = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] vars = new int[N+1][K+1];
		
		// 인덱스를 맞추기 위한 공갈데이터.
		products.add(new node(0,0));
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			products.add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(products);
		// 입력받기 끝.
		
		// 가져갈 물건의 갯수
		for(int i = 1; i < N+1; i++) {
			// 최대 들고 갈 수 있는 무게가 W
			node pd = products.get(i);
			for(int W = 1; W < K+1; W++) {
				if(pd.w <= W) {
					vars[i][W] = Math.max(pd.v + vars[i-1][W-pd.w], vars[i-1][W]);					
				}
				else vars[i][W] = vars[i-1][W];
			}
		}
		System.out.println(vars[N][K]);
	}
}
