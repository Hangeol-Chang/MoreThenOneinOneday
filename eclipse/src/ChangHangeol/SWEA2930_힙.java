package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA2930_힙 {
	static StringBuilder sb = new StringBuilder();
	
	static class Tree{
		ArrayList<Integer> tree = new ArrayList<>();
		Tree(){
			tree.add(Integer.MAX_VALUE);
		}
		// data 순으로 저장할거임.
		public void addnode(int data) {
			tree.add(data);
			int idx = tree.size()-1;
			
			while(data > tree.get(idx/2)) {
				switchdata(data, tree.get(idx/2), idx, idx/2);
				idx /= 2;
			}
		}
		public void delnode() {
			// 마지막꺼를 맨 앞에 넣고, 마지막꺼 지우기.
			if(tree.size() == 1) { sb.append(" -1"); return; }
			
			int idx = 1;
			int lastidx = tree.size() -1;
			int data = tree.get(lastidx);
			sb.append(" " + tree.get(1));
			tree.set(idx, data);
			tree.remove(lastidx);
			
			int[] idf = getdata(idx);
			while(data < idf[0] || data < idf[1]) {
				if(idf[0] < idf[1]) {
					switchdata(data, idf[1], idx, idx*2+1);
					idx = idx*2 +1;
				}
				else {
					switchdata(data, idf[0], idx, idx*2);
					idx *= 2;
				}
				idf = getdata(idx);
			}
		}
		
		public int[] getdata(int idx) {
			int idf1 = 0;
			int idf2 = 0;
			if(idx*2 < tree.size()) idf1 = tree.get(idx*2);
			if(idx*2 +1 < tree.size()) idf2 = tree.get(idx*2 +1);
			
			int[] idf = {idf1, idf2};
			return idf;
		}
		
		
		public void switchdata(int a, int b, int idx1, int idx2) {
			tree.set(idx1, b);
			tree.set(idx2, a);
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#" + t);
			tree = new Tree();
			for(int i = 0; i < n; i++) {
				
				st = new StringTokenizer(br.readLine());
				int act = Integer.parseInt(st.nextToken());
				
				switch(act) {
				case 1 :
					tree.addnode(Integer.parseInt(st.nextToken()));
					break;
				case 2 :
					tree.delnode();
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
