package LeeDoYeop;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class boj1918_후위표기식 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Character, Integer> priority = new HashMap<>();
		
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		
		String infix = sc.next(); 
		StringBuilder postfix = new StringBuilder();
		Stack<Character> op = new Stack<>(); 

		for (int i = 0; i < infix.length(); i++) {
			if (infix.charAt(i) == '(') {
				op.push(infix.charAt(i));
			}
			else if (infix.charAt(i) == ')') {
				while (op.peek() != '(')
					postfix.append(op.pop());
				op.pop(); 
			}

			else if (infix.charAt(i) >= 'A' && infix.charAt(i) <= 'Z') {
				postfix.append(infix.charAt(i));
			}

			else {
				if (op.isEmpty()) {
					op.push(infix.charAt(i));
				}
				else {
					while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(infix.charAt(i))) {
						postfix.append(op.pop());
					}
					op.push(infix.charAt(i));
				}
			}
		}
		while (!op.isEmpty()) {
			postfix.append(op.pop());
		}
		System.out.println(postfix.toString());
	}
}
