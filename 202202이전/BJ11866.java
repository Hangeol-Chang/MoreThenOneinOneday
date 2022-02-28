import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ11866 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> li = new LinkedList<>();

        //더해가면서 n보다 크면 n으로 나눈 나머지 잡기.

        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();      //버퍼 비우기

        int index = k;
        int size = n;
        
        //링크리스트 채워놓기.
        for(int i = 0; i <= n; i++) li.add(i);
        
        //뽑아내며 문자열 만들기
        //2번째부터는 , 를 붙여야하니, 첫번째꺼는 따로 붙임.
        sb.append("<");
        sb.append(li.remove(index--));
        size--;
        
        while(size > 0) {
            //콤마를 찍고 시작
            sb.append(", ");
            index += k;
            if(index > size) {
                index %= size;
                if(index == 0) index = size;
            }

            //System.out.println("index : " + index + ", size :" + size + ", comp : " + li.get(index));
            sb.append(li.remove(index--));
            size--;
        }
        sb.append(">");

        System.out.println(sb);
        in.close();
    }
}
