import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BJ10866 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<Integer>();
        int size = 0;

        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            String input = in.next();
            switch(input) {
                case "push_front" :
                    deq.addFirst(in.nextInt());
                    size++;
                    break;
                case "push_back" :
                    deq.addLast(in.nextInt());
                    size++;
                    break;
                case "pop_front" :
                    if(size > 0){
                        size--;
                        sb.append(deq.poll()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back" :
                    if(size > 0){
                        size--;
                        sb.append(deq.pollLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(size).append("\n");
                    break;
                case "empty" :
                    sb.append(size == 0 ? 1 : 0).append("\n");
                    break;
                case "front" :
                    if(size > 0){
                        sb.append(deq.peek()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back" :
                    if(size > 0){
                        sb.append(deq.peekLast()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
            }
            //System.out.println("현재 사이즈" + size);
        }
        System.out.println(sb);
        in.close();
    }
}
