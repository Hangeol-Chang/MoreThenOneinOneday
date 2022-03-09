package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ1697_숨바꼭질2 {
	static int goal = 0;
	static Queue<Integer> check = new LinkedList<Integer>();
	static int[] space = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		check.add(num);
		goal = Integer.parseInt(st.nextToken());
		
		if(num == goal) System.out.println(0);
		else {
		int time = 0;
			while(space[goal] == 0) {
				int loc = check.poll();
				time = space[loc]+1;
				
				int idx = loc - 1;
				if(idx >= 0 && space[idx] == 0) { space[idx] = time; check.add(idx); }
				idx = loc + 1;
				if(idx < 100001 && space[idx] == 0) { space[idx] = time; check.add(idx); }
				idx = loc * 2;
				if(idx < 100001 && space[idx] == 0) {space[idx] = time; check.add(idx); }
				
	//			for(int i = 0; i <= goal; i++) {
	//				System.out.print(space[i] + " ");
	//			}
	//			System.out.println();
			}
			System.out.println(space[goal]);
		}
	}
}

/*
5 17
5 6 12 18 17

*/