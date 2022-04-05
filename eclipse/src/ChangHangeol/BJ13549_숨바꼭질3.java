package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int max = 100001;
		int[] board = new int[max];
		Arrays.fill(board, Integer.MAX_VALUE);
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		que.add(N);
		board[N] = 1;
		
		while(!que.isEmpty()) {
			int loc = que.poll();
//			System.out.println(loc);
			
			if(loc+1 < max && board[loc+1] > board[loc]+1) {
				board[loc+1] = board[loc]+1;
				que.add(loc+1);
			}
			if(loc-1 >= 0 && board[loc-1] > board[loc]+1) {
				board[loc-1] = board[loc]+1;				
				que.add(loc-1);
			}
			if(loc*2 < max && board[loc*2] > board[loc]) {
				board[loc*2] = board[loc];
				que.add(loc*2);
			}
		}
		System.out.println(board[K]-1);
	}
}
