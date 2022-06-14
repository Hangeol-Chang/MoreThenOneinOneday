package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ9935_물자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ini = br.readLine();
		char[] ref = br.readLine().toCharArray();
		Stack<Character> stk = new Stack<>();
		Stack<Character> tmpstk = new Stack<>();
		
		for(int i = ini.length()-1; i >= 0; i--) stk.add(ini.charAt(i));
		// 문자열 스택화 완료
		
		
		int reflen = ref.length;
		int inilen, laslen = 0;
		do {
			inilen = stk.size();
			
			int loc = 0;
			while(!stk.isEmpty()) {
				char idf = stk.pop();
				tmpstk.add(idf);
				
				if(idf == ref[loc]) {
					if(loc == reflen-1)
						for(int d = 0; d < reflen; d++) tmpstk.pop();
					else
						loc++;
				}
				else {
					loc = 0;
					if( idf == ref[loc] ) loc = 1;
					
				}
			}
			
//			System.out.println(tmpstk.toString());
			stk.addAll(tmpstk);
			laslen = stk.size();
			
		} while(inilen != laslen);
		
		if(stk.isEmpty()) System.out.print("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while(!stk.isEmpty())
				sb.append(stk.pop());
			System.out.println(sb);
		}
	}
}

/*

a ababa baba caaa a ababa baba
ababa


*/