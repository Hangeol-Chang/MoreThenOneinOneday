package ChangHangeol;

 /* 
 * 함수가 실행되야 하는 횟수를 저장해서,
 * start위치에서 함수를 타고 들어가면서, 그 위치부터 출력해 나오기.
 * 스택 오버플로 날듯.
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1055_끝이없음2 {
	static StringBuilder sb = new StringBuilder();
	static int st, ed;
	static String S = "";
	static int[] lengths;
	
	static String ref;
	static int reflen;
	static int loc = 0;
	static int limit = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ref = br.readLine();
		reflen = ref.length();
		
		S = br.readLine();
		// S 안에 포함된 $의 수 세기.
		int refcount = 0;
		for(int i = 0; i < S.length(); i++) { if(S.charAt(i) == '$') refcount++; }
		int Slen = S.length() - refcount;
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer ST = new StringTokenizer(br.readLine());
		st = Integer.parseInt(ST.nextToken());
		ed = Integer.parseInt(ST.nextToken())+1;
		
		// 1번부터 n번까지 실행할 때, 문자열이 몇자리가 되는지 저장.
		lengths = new int[n+1];
		lengths[0] = reflen;
		for(int i = 1; i <= n; i++) {
			lengths[i] = lengths[i-1]*refcount + Slen;
			if(lengths[i] >= ed) {
				n = i;
				break;
			}
		}
		//입력받기 끝.
		limit = lengths[n];
		
		printSystem(n);
		int offset = ed - Math.max(lengths[n], st);
		if(offset > 0) {
			for(int i = 1; i < offset; i++) sb.append('-');
		}
		System.out.println(sb);
//		System.out.println("끝");
	}
	
	public static void printSystem(int n) {
		int i = 0;
		while(i < S.length()) {
//			System.out.println(i + " " + n + " " + loc);
			if(S.charAt(i) == '$') {

				if(loc + lengths[n] >= st) {
					if(n != 0) {
						printSystem(n-1);
					}else {
						for(int j = 0; j < reflen; j++) {
							loc++;
							if(loc >= st && loc < ed) sb.append(ref.charAt(j));
//							System.out.println(loc + " " + sb);
						}
					}
				}else loc += lengths[n];
			}
			else {
				loc += 1;
				if(loc >= st && loc <= limit && loc < ed) sb.append(S.charAt(i));
//				System.out.println(loc + " " + sb);
			}
			if(loc >= ed) return;
			i++;
		}
//		System.out.println();
	}
}
/*
abc
$x$y$z$
10
30 50

a
$b
1
999 1030

*/