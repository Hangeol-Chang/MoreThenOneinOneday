package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16953_AtoB {
	static class node {
		int num;
		int count;
		
		node(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
//		Queue<node> que = new LinkedList<>();
		
		int st = Integer.parseInt(stt.nextToken());
		int target = Integer.parseInt(stt.nextToken());
		
		int constant = 1;
		while((target % 2 == 0 || target % 10 == 1) && target > st) {
			constant++;
			if	   (target %2 == 0) target /= 2;
			else if(target %10 ==1) target /= 10;
			
//			System.out.println(target);
		}
		if(target == st) System.out.println(constant);
		else System.out.println(-1);
//		que.add(new node(st, 1));
//		while(!que.isEmpty()) {
//			node n = que.poll();
//			node[] nodes = new node[2];
//			nodes[0] = new node(n.num*2, n.count+1);
//			nodes[1] = new node(n.num*10 + 1, n.count+1);
//			
//			for(int i = 0; i < 2; i++) {
//				int num = nodes[i].num;
//				if(num < target) que.add(nodes[i]);
//				else if(num == target) {
//					System.out.println(nodes[i].count + constant);
//					return;
//				}
//			}
//		}
//		System.out.println(-1);
	}
}
