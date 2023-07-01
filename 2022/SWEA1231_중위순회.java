

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231_중위순회 {
	static class node{
		char data;
		int l;
		int r;
	}
	static node[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			tree = new node[n+1];
			for(int i = 0; i <= n; i++) tree[i] = new node();
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int loc = Integer.parseInt(st.nextToken());
				tree[loc].data = st.nextToken().charAt(0);
				
				// 자식이 없으면 예외나는거를 처리하기 위해 트라이문을 검.
				try {
					tree[loc].l = Integer.parseInt(st.nextToken());
					tree[loc].r = Integer.parseInt(st.nextToken());				
				}catch (Exception e) {
					continue;
				}
			}
			// 입력받기 끝.
			
			midrun(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void midrun(int idx) {
		if(tree[idx].l != 0) midrun(tree[idx].l);
		sb.append(tree[idx].data);
		if(tree[idx].r != 0) midrun(tree[idx].r);
	}
}
