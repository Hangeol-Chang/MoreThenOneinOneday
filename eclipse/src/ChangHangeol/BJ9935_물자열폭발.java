package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		// KMP 전처리
		int reflen = ref.length;
		int[] table = new int[reflen];
		
		int idx = 0;
		for(int i = 1; i < reflen; i++) {
			while(idx > 0 && ref[i] != ref[idx]) idx = table[idx-1];
			
			if(ref[i] == ref[idx]) {
				idx += 1;
				table[i] = idx;
			}
		}
		System.out.println(Arrays.toString(table));
		
		int inilen, laslen = 0;
		do {
			inilen = stk.size();
			
			int loc = 0;
			outer : while(!stk.isEmpty()) {
				char idf = stk.pop();
				// 불일치시 저치
				while(loc > 0 && idf != ref[loc]) {
					tmpstk.add(idf);
					int tmploc = 
					loc = table[loc-1];
					try {
						idf = stk.pop();
					} catch (Exception e) {
						continue outer;
					}
				}
				
				// 일치할 시 
				if(idf == ref[loc]) {
					// 전부 일치하면 스택에서 뽑아버리기.
					if(loc == reflen-1) {
						// reflen-1개를 지워야 함.
						for(int d = 0; d < reflen-1; d++)
							tmpstk.pop();
						loc = 0;
					}
					else {
						loc++;
						tmpstk.add(idf);
					}
				}
				else {
					tmpstk.add(idf);
				}
			}
			while(!tmpstk.isEmpty()) stk.add(tmpstk.pop());
			System.out.println(stk.toString());
			laslen = stk.size();
		} while(inilen != laslen);
		
		if(stk.isEmpty()) System.out.print("FRULA");
		else
			while(!stk.isEmpty())
				System.out.print(stk.pop());
	}
}

/*

a ababa baba caaaa ababa baba
ababa


*/