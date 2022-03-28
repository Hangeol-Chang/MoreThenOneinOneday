package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA2930_힙 {
	static StringBuilder sb = new StringBuilder();
	
	static class Tree{
		static int size = 0;
		HashMap<Integer, Integer> tree = new HashMap<>();
		
		// data, idx 순으로 저장할거임.
		public void addtree(int data) {
			size++;
			tree.put(size, data);
		}
		public void delnode() {	
			int data = tree.get(size);
			sb.append(tree.get(1) + " ");
			tree.put(1,  data);
			tree.remove(size--);
			// 1번 자리를 마지막걸로 덮어씌우고, 마지막꺼 날리고 사이즈 1 빼기.
			
			int idx = 1;
			// key, value로 저장
			int[] idf1 = {idx*2, tree.get(idx*2) != null ? tree.get(idx*2) : 0};
			int[] idf2 = {idx*2+1, tree.get(idx*2+1)};
			int[] maxidf = new int[2];
			while( idf1[1] > data || idf2[2] > data) {
				if(idf1[1] > idf2[1]) maxidf = idf1;
				else 				  maxidf = idf2;
				// 최댓값을 골라오고
				
				tree.put(idx, maxidf[1]);
				// 최대값 바꾸고,
				idx = maxidf[0];
				// 내 다음 위치 설정.
				tree.put(idx, data);
				// 바뀐 위치에 내꺼 넣기.
			}
		}
		Tree(){
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Tree tree;
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			tree = new Tree();
			for(int i = 0; i < n; i++) {
				sb.append("#" + t + " ");
				
				st = new StringTokenizer(br.readLine());
				int act = Integer.parseInt(st.nextToken());
				
				switch(act) {
				
				}
			}
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		System.out.println(map.get(1));
	}
}
