package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1918_후위표기식 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        // 0은 더미데이터임.
        String ref = "(0+-/*)";

        String ori = br.readLine();
        int len = ori.length();
        
        for(int i = 0; i < len; i++){
            char c = ori.charAt(i);
            int idf = ref.indexOf(c);
            switch(idf) {
            case -1 :
                sb.append(c);
                break;
            case 0 :
                stk.add(idf);
                break;
            case 2 :
            case 3 :
            case 4 :
            case 5 :
                while(!stk.isEmpty() && stk.peek()/2 >= idf/2)
                    sb.append(ref.charAt(stk.pop()));
                stk.add(idf);
                break;
            case 6 :
                while(!stk.isEmpty() && stk.peek() != 0)
                    sb.append(ref.charAt(stk.pop()));
                stk.pop();
                break;
            }
        }
        while(!stk.isEmpty())
            sb.append(ref.charAt(stk.pop()));

        System.out.println(sb);
    }
}
