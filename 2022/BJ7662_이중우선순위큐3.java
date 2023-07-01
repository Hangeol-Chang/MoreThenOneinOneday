

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 해쉬맵
 */
public class BJ7662_이중우선순위큐3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 우선순위 큐를 두개 선언하여, 하나는 역순으로 사용.
		class DpQueue {
			HashMap<Long, Integer> map = new HashMap<>();
			
			public void add(long num){
				int count = 0;
				if(map.containsKey(num)) count = map.get(num);
				map.put(num, count+1);
			}
			public void remove(int idf) {
				if(map.isEmpty()) return;
				
				long key = 0;
				if(idf == 1) { key = Collections.max(map.keySet()); }
				else 		 { key = Collections.min(map.keySet()); }
				
				int count = map.get(key);
				if(count > 1) map.put(key, count-1);
				else map.remove(key);
			}
			
			public String printSystem() {
				if(map.isEmpty()) return "EMPTY";
				else return Collections.max(map.keySet()) + " " + Collections.min(map.keySet());
			}
			
			public void clear() { map = new HashMap<>(); }
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		DpQueue dpque = new DpQueue();
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			dpque.clear();
			int K = Integer.parseInt(br.readLine());
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
//				System.out.println(dpque.map);
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

2
9
D 1
I 1207
I 3471
I 3574
I -5575
D -1
D 1
D 1
D -1
9
D -1
D -1
I 8088
D 1
I 5585
I 9097
I -6416
D 1
D -1

*/