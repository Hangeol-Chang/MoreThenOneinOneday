package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1232_사칙연산 {
	static class node{
		String data;
		int l;
		int r;
	}
	
	static node[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		outer : for(int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			tree = new node[n+1];
			for(int i = 0; i <= n; i++) tree[i] = new node();
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int loc = Integer.parseInt(st.nextToken());
				tree[loc].data = st.nextToken();
				
				// 자식이 없으면 예외나는거를 처리하기 위해 트라이문을 검.
				try {
					tree[loc].l = Integer.parseInt(st.nextToken());
					tree[loc].r = Integer.parseInt(st.nextToken());				
				}catch (Exception e) {
					continue;
				}
			}
			// 입력받기 끝.
			int result = (int)calc(1);
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	
	public static float calc(int i) {
		// 여기 값이 정수면 그냥 반환
		String data = tree[i].data;
		try {
			float num = Integer.parseInt(data);
			return num;
		}catch (Exception e) {
			// 정수가 아니면,
			// 왼쪽 밑 노드와, 오른쪽 밑 노드의 결과값을 가져와서 연산.
			float idf1 = calc(tree[i].l);
			float idf2 = calc(tree[i].r);
			
//			System.out.println(idf1 + " " + tree[i].data + " " + idf2);
			switch(tree[i].data) {
			case "+" :
				return idf1 + idf2;
			case "*" :
				return idf1 * idf2;
			case "-" :
				return idf1 - idf2;
			case "/" :
				return idf1 / idf2;
			default :
				return 0;
			}
		}
	}
}
