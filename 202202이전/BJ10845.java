import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10845 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<Integer>();
        int last = 0;
        int size = 0;

        //n입력받기
        int n = in.nextInt();
        
        for(int i = 0; i < n; i++){
            
            // 명령 입력받기
            String order = in.next();
            
            switch(order){
                case "push" :
                    //큐에 숫자를 입력받아서 추가.
                    last = in.nextInt();
                    que.add(last);
                    size++;
                    break;
                case "pop" :
                    //que가 비어있으면 -1, 아니면 pop해서 출력
                    if(size == 0){
                        sb.append("-1\n");
                    }
                    else{
                        sb.append(que.poll()).append("\n");
                        size--;
                    }
                    break;
                case "size" :
                    //size출력
                    sb.append(size).append("\n");
                    break;
                case "empty" :
                    //3항연산자로 출력
                    sb.append(size==0 ? 1 : 0).append("\n");
                    break;
                case "front" :
                    // 비어있으면 -1, 아니면 수 출력
                    sb.append(size==0 ? -1 : que.peek()).append("\n");
                    break;
                case "back" :
                    //비었으면 -1, 아니면 정수 출력.
                    sb.append(size==0 ? -1 : last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        in.close();
    }
}
