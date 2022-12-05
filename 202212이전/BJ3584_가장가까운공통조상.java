

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ3584_가장가까운공통조상 {
	static class node {
		int data;
		ArrayList<Integer> child;
		
		node() {
			child = new ArrayList<>();
		}

		void addchild(int c) {
			child.add(c);
		}
	}
	static node[] tree;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			// 트리 초기화
			tree = new node[n+1];
			for(int i = 0; i <= n; i++) tree[i] = new node();

			for(int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				tree[p].addchild(c);
			}
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 입력받기 끝
			
			int root = findroot(1);
//			System.out.println(root);
			
			int adept = finddept(root, 0, a);
			int bdept = finddept(root, 0, b);
//			System.out.println(adept + " " + bdept);
			while(adept != bdept) {
				if(adept > bdept) { a = findparent(a); adept--; }
				else			  { b = findparent(b); bdept--; }
			}
			while(a != b) {
				a = findparent(a);
				b = findparent(b);
			}
			sb.append(a + "\n");
		}
		System.out.println(sb);	
	}
	
	public static int findroot(int data) {
		int d = findparent(data);
		int save = data;
		while(d != 0) {
			save = d;
			d = findparent(d);
		}
		return save;
	}
	
	public static int finddept(int node, int dept, int target) {
//		System.out.println(node + " " + dept + ", target : " + target);
		if(node == target) return dept;
		int tmp = 0;
		
		// 자식을 다 돌면서 찾아내면 찾아낸 값 반환.
		for(int c : tree[node].child){
			int tmptmp = finddept(c, dept+1, target);
			if(tmptmp != 0) tmp = tmptmp;
			
		}
		return tmp;
	}
	// 부모 찾기
	public static int findparent(int data) {
		for(int i = 1; i < n+1; i++) {
			for(int c : tree[i].child) {
				if(c == data) return i;
			}
		}
		return 0;
	}
}

/*
1
5
2 3
3 4
3 1
1 5
3 5

*/