

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11651_좌표정렬하기2 {
	static class node implements Comparable<node>{
		int f, s;
		node(String f, String s){
			this.f = Integer.parseInt(f);
			this.s = Integer.parseInt(s);
		}
		@Override
		public int compareTo(node o) {
			if(this.s != o.s) return this.s - o.s;
			else 			  return this.f - o.f;
		}
		@Override
		public String toString() {
			return this.f + " " + this.s;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<node> que = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			que.add(new node(st.nextToken(), st.nextToken()));
		}
		
		while(!que.isEmpty()){
			System.out.println(que.poll());
		}
	}
}
