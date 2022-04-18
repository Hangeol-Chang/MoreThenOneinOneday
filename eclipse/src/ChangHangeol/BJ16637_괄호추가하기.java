package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ16637_괄호추가하기 {
	static long ans;
	static int N;
	static ArrayList<Integer> sel = new ArrayList<>();
	static ArrayList<Character> idfs = new ArrayList<>();
	static ArrayList<Integer> nums = new ArrayList<>();
	static String ini;

	static boolean[] vi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		vi = new boolean[N/2];
		// 입력받기.
		ini = br.readLine();
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0)
		}
		
		
		ans = Integer.MIN_VALUE;
		calc();
		select(0);
		System.out.println(ans);
	}
	public static void select(int idx) {
		if(idx >= N/2) {
			calc();
			return;
		}
		
		for(int i = idx; i < N/2; i++) {
			if(vi[i]) continue;
			// 여기 처리한걸로 해주기.
			vi[i] = true;
			if(i < N/2 -1) vi[i+1] = true;
			
			sel.add(i);
			select(i+2);
			
			// 원상복구
			sel.remove(sel.size()-1);
			vi[i] = false;
			if(i < N/2 -1) vi[i+1] = false;
		}
	}
	
	// 후위연산으로 바꾸면서 진행.
	public static void calc() {
		// sel 배열에, 괄호를 넣을 위치가 나옴.
		// 0이면, 0 앞 2 뒤
		// 1이면, 2 앞 4 뒤
		// i번째에, i*2 앞, (i+1)*2 뒤에 괄호 추가.
		// i번째 연산자의 위치는 i*2 + 1;
        String ref = "()+-*";
        Stack<Character> stack = new Stack<>();
        // 새로 만들 식 넣을 곳.
        StringBuilder sik = new StringBuilder();
        Stack<Long> intstack = new Stack<>();
        
        // 후위연산식으로 만들기.
        int idx = 0;
        for(int i = 0; i < N; i++) {
        	// "(" 입력.
        	if(idx < sel.size() && i == sel.get(idx)*2) stack.push('(');
        	
        	// 실제 식 작업.
        	char tmp = ini.charAt(i);
        	int num = ref.indexOf(tmp);
            
            //없으면 숫자이므로, 새로운 식에 그냥 대입.
            if(num == -1) { sik.append(tmp);}
            else {
                //연산자이면 우선순위 비교 후 처리.
                while(!stack.isEmpty() && stack.peek() != '(') 
                    sik.append(stack.pop());
                stack.push(tmp);
            }
            
        	// ")" 입력.
        	if(idx < sel.size() && i == (sel.get(idx)+1) *2) {
        		while(!stack.isEmpty() && stack.peek() != '(')
        			sik.append(stack.pop());
        		idx++;
        		stack.pop();
        	}
        }
        while(!stack.isEmpty()) { sik.append(stack.pop()); }
        // 후위연산식 제작 완료.
        
        int len = sik.length();
        long cala = 0;
        long calb = 0;
        for( int i = 0; i < len; i++) {
            //새로운 식에서 하나씩 꺼내오면서 검사.
            char tmp = sik.charAt(i);
             
            //꺼내온게 숫자면 스택에 집어넣음.
            if(ref.indexOf(tmp) == -1) intstack.push((long)(tmp - '0'));
            else {
                //숫자가 아니면 스택에서 숫자 뽑아서 연산.
                calb = intstack.pop();
                cala = intstack.pop();
                long cal = 0;
                switch (tmp) {
                case '+' :
                    cal = cala + calb;
                    break;
                case '-' :
                    cal = cala - calb;
                    break;
                case '*' :
                    cal = cala * calb;
                    break;
                }
                //연산한거 다시 스택에 넣음.
                intstack.push(cal);
            }

        }
        long m = intstack.pop();
        ans = Math.max(ans, m);
        
        System.out.println("한회 완료");
        System.out.println(sel);
        System.out.println(m + ", 최대  " + ans);
        System.out.println();
        return;
	}
}

/*

19
1*2+3*4*5-6*7*8*9*0

17
1*1*1*1*1*1*2*1-2

*/