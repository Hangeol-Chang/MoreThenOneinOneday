package LeeDoYeop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10773_제로 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)
				stack.pop();
			else
				stack.add(num);
		}
		int sum = 0;
		while(!stack.isEmpty())
			sum += stack.pop();
		System.out.println(sum);
	}
}
