

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966_프린터큐 {
	static class node{
		int idx, data;
		node(int i, int d){
			this.idx = i;
			this.data = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<node> que = new LinkedList<>();
			for(int i = 0; i < N; i++)
				que.add(new node(i, Integer.parseInt(st.nextToken())));
			
			int count = 1;
			ww : while(true) {
				// 나보다 큰 데이터가 하나라도 있으면
				node a = que.poll();
				for(node nd : que) {
					if(nd.data > a.data) {
						que.add(a);
						continue ww;
					}
				}
				if(a.idx == I)
					break ww;
				count++;
			}
			System.out.println(count);
		}
	}
}
