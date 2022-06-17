

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 전위순회 결과 주고, 후위순회 결과 구해라.
// 이 트리는 자료 크기로 구분된 트리임.
public class BJ5639_이진검색트리 {
	static StringBuilder sb = new StringBuilder();
	
	static class node{
		node left, right;
		int data;

		node(int data){
			this.data = data;
		}
		
		// 트리 만들어버리기.
		public void insertdata(int newdata){
			if(newdata < data) {
				if(left == null) left = new node(newdata);
				else			 left.insertdata(newdata);
			}else {
				if(right == null) right = new node(newdata);
				else			  right.insertdata(newdata);
			}
		}
		
		public void printSystem() {
			if(left != null) left.printSystem();
			if(right!= null) right.printSystem();
			
			sb.append(data + "\n");
		}
	}
	public static void main(String[] args) {
		// 자료가 작아지면 왼쪽으로 내랴가는 것.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<Integer>();
		while(true) {
			try {
				que.add(Integer.parseInt(br.readLine()));
			}catch(IOException e1){
				break;
			}catch(NumberFormatException e) {
				break;
			}
		}
		// 입력 완료.
		
		node root = new node(que.poll());
		while(!que.isEmpty()) root.insertdata(que.poll());
		
		root.printSystem();
		System.out.println(sb);
	}
}
