package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 시간 초과
 */
public class BJ7662_이중우선순위큐2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 우선순위 큐를 두개 선언하여, 하나는 역순으로 사용.
		class DpQueue {
			PriorityQueue<Long> lowque = new PriorityQueue<>();
			PriorityQueue<Long> highque = new PriorityQueue<>(Collections.reverseOrder());
			int size = 0;
			
			public void add(long num){
				lowque.offer(num);
				highque.offer(num);
				size++;
			}
			public void remove(int idf) {
				if(idf == 1) { lowque.remove(highque.poll()); }
				else { highque.remove(lowque.poll()); }
				if(--size <= 0) { this.clear(); }
			}
			
			public String printSystem() {
				if(size == 0) return "EMPTY";
				else return highque.peek() + " " + lowque.peek();
			}
			public void clear() {
				size = 0;
				highque.clear();
				lowque.clear();
			}
//			public void debug() {
//				System.out.println("밑 : " + lowque);
//				System.out.println("위 : " + highque + "\n");
//			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		DpQueue dpque = new DpQueue();
		
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			dpque.clear();
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				case "I" :
					dpque.add(Long.parseLong(st.nextToken()));
					break;
				case "D" :
					dpque.remove(Integer.parseInt(st.nextToken()));
					break;
				}
//				dpque.debug();
			}
			sb.append(dpque.printSystem()+ "\n");
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

1
9
I 1
I 2
I 3
D -1
D -1
I -1
I -2
I -3
D 1

*/