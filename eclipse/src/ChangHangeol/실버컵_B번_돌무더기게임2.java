package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 0이 두개가 되는 순간 끝.
 * 제일 작은 수부터 꺼내서, 제일 큰 것에 넣어야 함.
 * 
 * 2로 나눈 나머지끼리 계산해도 됨.
 */
public class 실버컵_B번_돌무더기게임2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
			for(int i = 0; i < 3; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int p = que.poll();
			int p1 = (p / 2) *2;
			int p2 = que.poll() - p1;
			int p3 = que.poll() - p%2;
			
			sb.append(((p2 %2 == 0)? "R" : "B") +"\n");
		}
		System.out.println(sb);
	}
}
