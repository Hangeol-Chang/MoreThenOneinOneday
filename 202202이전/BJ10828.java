import java.util.Scanner;
import java.util.Stack;
//스택 안쓰고 풀어보기.

public class BJ10828 {
    //스택 선언
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();           //n입력받기

        //n번 입력받기
        for(int i = 0; i < n; i++){
            
            // 명령 입력받기
            String order = in.next();
            
            switch(order){
                case "push" :
                    //스택에 숫자를 입력받아서 추가.
                    stack.push(in.nextInt());
                    break;
                case "pop" :
                    //stack이 비어있으면 -1, 아니면 pop해서 출력
                    sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size" :
                    //size출력
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    //3항연산자로 출력
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;
                case "top" :
                    //stack이 비어있으면 -1, 아니면 수 출력
                    sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        in.close();
    }
}
