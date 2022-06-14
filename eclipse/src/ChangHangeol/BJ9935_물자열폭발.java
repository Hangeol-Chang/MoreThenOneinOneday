package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9935_물자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] ini = br.readLine().toCharArray();
		char[] ref = br.readLine().toCharArray();
		Stack<Character> stk = new Stack<>();
		
		int ilen = ini.length;
		int reflen = ref.length;
		for(int i = 0; i < ilen; i++) {
			stk.add(ini[i]);
			
//			System.out.println("사이클 시작 : " + stk.toString());
			
			if(ini[i] == ref[reflen-1]) {
				Stack<Character> tmpstk = new Stack<>();
				int loc = reflen;
				
				char a;
				do {
					loc--;
					if(loc >= 0 && stk.size() > 0) {
						a = stk.pop();
						tmpstk.add(a);						
					}
					else break;
					
				} while(loc >= 0 && a == ref[loc]);
				
				
				// 여기 오면 통과
				if(loc < 0) {
//					System.out.println("성공");
					continue;
				}
				// 여기 오면 실패
				else {
//					System.out.println("실패");
					while(!tmpstk.isEmpty())
						stk.add(tmpstk.pop());
				}
			}
//			System.out.println("사이클 끝 : " + stk.toString());
		}
		// 연산 끝.
		
		if(stk.isEmpty()) System.out.print("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while(!stk.isEmpty()) sb.append(stk.pop());
			System.out.print(sb.reverse());
		}
	}
}

/*

aaabbb
ba

aababababacaaaaababababa
ababa

abcdef
abd

*/