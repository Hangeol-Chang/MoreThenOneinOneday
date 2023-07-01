

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ11286_절댓값힙 {
	static class data implements Comparable<data>{
		int ori, abs;
		data(int ori){
			this.ori = ori;
			this.abs = Math.abs(ori);
		}
		@Override
		public int compareTo(data o) {
			if(this.abs != o.abs) return this.abs - o.abs;
			else				  return this.ori - o.ori;
		}
		
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<data> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				if(pq.size() == 0) sb.append("0\n");
				else			   sb.append(pq.poll().ori + "\n");
			else
				pq.add(new data(num));
		}
		System.out.print(sb);
	}
}