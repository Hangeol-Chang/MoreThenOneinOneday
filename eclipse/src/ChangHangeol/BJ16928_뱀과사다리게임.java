package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16928_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = N+M;
		
		HashMap<Integer, Integer> ladder = new HashMap<>();
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 사다리 입력 완료
		
		int[] map = new int[101];
		Queue<Integer> loc = new LinkedList<Integer>();
		loc.add(1);
		map[1] = 1;
		
		while(map[100] == 0) {
			int now = loc.poll();
			
			for(int r = 1; r <= 6; r++) {
				if(now + r > 100) break;
				int to = now + r;
				
				if(map[to] == 0) {
					if(ladder.containsKey(to)) {
						int la = ladder.get(to);
						
						if(map[la] == 0) {
							map[la] = map[now] + 1;
							loc.add(la);
						}
						map[to] = -1;
					}
					else {						
						map[to] = map[now] + 1;
						loc.add(to);
					}
				}
			}
//			System.out.println(Arrays.toString(map));
		}
		System.out.println(map[100]-1);
	}
}
