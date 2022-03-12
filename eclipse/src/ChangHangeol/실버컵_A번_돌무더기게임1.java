package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 실버컵_A번_돌무더기게임1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int i = 0; i < 3; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int p1 = que.poll();
			int p2 = que.poll();
			int p3 = que.poll();
			
			if(p1 == p2) { sb.append(((p1 % 2 == 0) ? "R" : "B") + "\n"); }
			else if(p2 == p3) { sb.append(((p2 % 2 == 0) ? "R" : "B") + "\n"); }
			else { sb.append((((p2-p1)%2 == 0) ? "R" : "B" ) + "\n"); }
		}
		System.out.println(sb);
	}
}
