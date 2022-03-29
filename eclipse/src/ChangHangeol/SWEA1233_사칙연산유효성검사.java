package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233_사칙연산유효성검사 {
	static class node{
		int data;
		int l;
		int r;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		outer : for(int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			node[] tree = new node[n+1];
			for(int i = 0; i <= n; i++) tree[i] = new node();
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int loc = Integer.parseInt(st.nextToken());
				tree[loc].data = (int)(st.nextToken().charAt(0));
				
				// 자식이 없으면 예외나는거를 처리하기 위해 트라이문을 검.
				try {
					tree[loc].l = Integer.parseInt(st.nextToken());
					tree[loc].r = Integer.parseInt(st.nextToken());				
				}catch (Exception e) {
					continue;
				}
			}
			// 입력받기 끝.
			
			// 유효성 검사
			// 연산자인데 자식이 없거나
			// 피연산자인데 자식이 있으면 불가능.
			for(int i = 1; i <= n; i++) {
				int data = tree[i].data;
				
				// 통과하면 숫자.
				if(data >= 48) {
					if( tree[i].r != 0 || tree[i].l != 0){
						sb.append(0 + "\n");
						continue outer;
					}
				}else {
					if( tree[i].r == 0 || tree[i].l == 0) {
						sb.append(0 + "\n");
						continue outer;
					}
				}
			}
			sb.append(1 + "\n");
		}
		System.out.println(sb);
	}
}
