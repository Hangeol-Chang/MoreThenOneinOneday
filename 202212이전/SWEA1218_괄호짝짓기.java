
import java.util.Scanner;
import java.util.Stack;

public class SWEA1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			Stack<Integer> stack = new Stack<>();
			sb.append("#" + t + " ");
			//입력받기
			int len = in.nextInt();
			in.nextLine();
			
			String str = in.nextLine();
			
			String search = "({[<)}]>";
			
			boolean pass = true;
			for(int i = 0; i < len; i++) {
				int tmp = search.indexOf(str.charAt(i));
				//System.out.print(tmp);
				if(tmp > 3) {
					if(stack.peek() == tmp%4) stack.pop();
					else { pass = false; break; }
				} else { stack.push(tmp); }
			}
			//System.out.println(pass + " " + stack.isEmpty());
			if(pass && stack.isEmpty()) sb.append("1\n");
			else sb.append("0\n");
		}
		System.out.println(sb);
		in.close();
	}
}
