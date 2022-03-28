package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA2930_힙2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t);
			int n = Integer.parseInt(br.readLine());
			pque.clear();
			
			for(int i = 0; i < n; i++) {
				
				st = new StringTokenizer(br.readLine());
				int act = Integer.parseInt(st.nextToken());
				
				int data = 0;
				switch(act) {
				case 1 :
					data = Integer.parseInt(st.nextToken());
					pque.add(data);
					break;
				case 2 :
					if(!pque.isEmpty()) data = pque.poll();
					else data = -1;
					sb.append(" " + data);						
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
