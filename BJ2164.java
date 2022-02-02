import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2164 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i < n+1; i++){
            que.add(i);
        }

        boolean sw = false;     //false일 때 앞에꺼 비우기, true일 때 뒤에 추가.
        while( que.size() > 1 ){
            if(sw) {
                que.add(que.poll()); 
                sw = false;
            } else {
                que.poll();          
                sw = true;
            }
        }
        System.out.println(que.poll());
    }
}

/*
1 > 1
2 > 12 2
3 > 123 - 23 - 32 - 2
4 > 1234 - 234 - 342 - 42 - 24 - 4
5 > 12345 - 2345 - 3452 - 452 - 524 - 24 - 42 - 2
*/
