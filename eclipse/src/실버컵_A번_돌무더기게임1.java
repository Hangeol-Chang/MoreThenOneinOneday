

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0이 두개가 되는 순간 끝.
 * 제일 작은 수부터 꺼내서, 제일 큰 것에 넣어야 함.
 * 
 * 2로 나눈 나머지끼리 계산해도 됨.
 */
public class 실버컵_A번_돌무더기게임1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int i = 0; i < 3; i++) {
				que.add(Integer.parseInt(st.nextToken()) % 2);
			}
			
			int count = 0;
			while(playgame(que)) {
//				System.out.println(que);
				count++;
			}
			sb.append(((count%2 == 0) ? "R" : "B" ) + "\n");
		}
		System.out.println(sb);
	}
	public static boolean playgame(PriorityQueue<Integer> que) {
		Queue<Integer> tmpque = new LinkedList<>();
		
		int pickcount = 0;
		for(int i = 0; i < 3; i++) {
			int get = que.poll();
			if(get != 0) {
				get--;
				pickcount++;
			}
			tmpque.add(get);
			
			if(pickcount == 2) {
				if(tmpque.size() == 2) {
					que.add(que.poll()+1);
					while(tmpque.size() > 0) que.add(tmpque.poll());
				}
				else {
					que.add(tmpque.poll() + 1);
					while(tmpque.size() > 0) que.add(tmpque.poll());
				}
				return true;
			}
		}
		// 2개 이상 뽑을 수 없으면 false
		return false;
	}
}
