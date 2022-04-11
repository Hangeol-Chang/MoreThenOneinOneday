package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 전위순회 결과 주고, 후위순회 결과 구해라.
// 이 트리는 자료 크기로 구분된 트리임.
public class BJ5639_이진검색트리_인데이제중위순회인줄알고풀어본 {
	static class node{
		int data;
		node left;
		node right;
		node parent;
		// 값과 부모의 주소를 저장.
		node(int data, node parent){
			this.data = data;
			this.parent = parent;
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
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		// 중위순회 출력구조.
		// 전위순회 구조를 바탕으로 트리를 생성.
		System.out.println(que);
		int last = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			while(!stk.isEmpty() && stk.peek()  < now) {
				sb.append(stk.pop() + "\n");
			}
			stk.add(now);
		}
		while(!stk.isEmpty())
			sb.append(stk.pop() + "\n");
		
		System.out.println(sb);
	}
}
