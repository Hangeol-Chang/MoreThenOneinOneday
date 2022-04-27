package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12851_숨바꼭질2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num  = Integer.parseInt(st.nextToken());
		int	goal = Integer.parseInt(st.nextToken());
		
		int count = 1;
		
		int[] dist = new int[200001];
		Arrays.fill(dist, 100000);
		dist[num] = 0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(num);
		
		while(!que.isEmpty()) {
			int nownum = que.poll();
			if(nownum == goal) break;
			
			if(nownum >  0		&& dist[nownum-1] >= dist[nownum] + 1) {
				dist[nownum-1] = dist[nownum] + 1;
				que.add(nownum-1);
			}
			if(nownum <  200000 && dist[nownum+1] >= dist[nownum] + 1) {
				dist[nownum+1] = dist[nownum] + 1;
				que.add(nownum+1);
			}
			if(nownum <= 100000 && dist[nownum*2] >= dist[nownum] + 1) {
				dist[nownum*2] = dist[nownum] + 1;
				que.add(nownum*2);
			}
		}
		while(!que.isEmpty()) {
			if(que.poll() == goal) count++;
		}

		System.out.println(dist[goal] + "\n" + count);
	}
}