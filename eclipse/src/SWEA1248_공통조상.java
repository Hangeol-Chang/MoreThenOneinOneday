

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1248_공통조상 {
	static int[][] tree;
	static int n, size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree = new int[n+1][2];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < k; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(tree[p][0] == 0) tree[p][0] = c;
				else				tree[p][1] = c;
			}
			// 입력받기 끝
			
			int adept = finddept(1, 0, a);
			int bdept = finddept(1, 0, b);
			while(adept != bdept) {
				if(adept > bdept) { a = findparent(a); adept--; }
				else			  { b = findparent(b); bdept--; }
			}
			while(a != b) {
				a = findparent(a);
				b = findparent(b);
			}
			
			size = 0;
			findsize(a);
			sb.append("#" + t + " " + a + " " + size + "\n");
		}
		System.out.println(sb);		
	}
	public static int finddept(int node, int dept, int target) {
		if(node == target) return dept;
		int tmp = 0;
		
		// 왼쪽에서 찾아내면 찾아낸 값 반환.
		if(tree[node][0] != 0) tmp = finddept(tree[node][0], dept+1, target);
		if(tmp != 0) return tmp;
		// 왼쪽에서 못찾으면 오른쪽에서 찾기.
		if(tree[node][1] != 0) tmp = finddept(tree[node][1], dept+1, target);
		return tmp;
	}
	
	// 부모 찾기
	public static int findparent(int data) {
		for(int i = 1; i < n+1; i++) {
			for(int d = 0; d < 2; d++) {
				if(tree[i][d] == data) return i;
			}
		}
		return 0;
	}
	
	public static void findsize(int root) {
		size++;
		if(tree[root][0] != 0) findsize(tree[root][0]);
		if(tree[root][1] != 0) findsize(tree[root][1]);
	}
}

/*
1
50 49 24 31
31 7 2 17 27 32 14 30 1 21 45 26 44 27 39 11 26 3 48 6 3 44 2 49 42 13 48 8 23 33 11 10 8 42 41 31 17 4 8 22 25 23 21 41 28 25 13 16 46 2 31 35 42 19 32 18 27 50 45 15 28 20 46 28 44 40 40 5 15 48 9 34 1 46 17 29 35 36 21 45 14 37 23 14 6 39 11 9 19 24 26 47 16 38 40 12 47 43


*/