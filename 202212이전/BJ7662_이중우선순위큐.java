

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 시간 초과
 */

public class BJ7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 이중 우선순위 큐 정의
		class pque {
			LinkedList<Long> que = new LinkedList<>();
			
			// 이진탐색으로 넣기.
			public void add(long num) {
				if(que.size() == 0 || que.peekLast() <= num) { que.add(num); return; }
				
				int st = 0;
				int ed = que.size()-1;
				int mid = 0;
				do {
					mid = (st+ed)/2;
					if(que.get(mid) <= num) st = mid + 1;
					else ed = mid - 1;
				} while(st < ed);
				
				que.add(mid, num);
			}
			
			public void delete(int identifier) {
				if(que.isEmpty()) return;
				if(identifier == 1) {
					que.removeLast();
				}else {
					que.remove();
				}
			}
			public String printSystem() {
				return que.peekLast() + " " + que.peekFirst();
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		pque dpque = new pque();
		
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				case "I" :
					dpque.add(Long.parseLong(st.nextToken()));
					break;
				case "D" :
					dpque.delete(Integer.parseInt(st.nextToken()));
					break;
				}
//				System.out.println(dpque.que);
			}
			if(dpque.que.isEmpty()) sb.append("EMPTY\n");
			else sb.append(dpque.printSystem() + "\n");
		}
		System.out.println(sb);
	}
}

/*
2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1

9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
*/