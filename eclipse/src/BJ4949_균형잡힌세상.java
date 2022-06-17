

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ref = "()[]";
		StringBuilder sb = new StringBuilder();

		unit : while(true){
			String str = br.readLine();
			if(str.equals(".")) break;
			
			Stack<Integer> stk = new Stack<>();
			for(char a : str.toCharArray()) {
				int num = ref.indexOf(a);
				
				switch(num%2){
				case 0 :	// 여는 괄호.
					stk.add(num);
					break;
				case 1 :
					if(!stk.isEmpty() && stk.peek()/2 == num/2) {
						stk.pop();
					}else {
						sb.append("no\n");
						continue unit;
					}
				}
			}
			if(stk.isEmpty()) sb.append("yes\n");
			else 			  sb.append("no\n");
		}
		System.out.println(sb);
	}
}
