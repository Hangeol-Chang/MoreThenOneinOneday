

 /* 
 * 함수가 실행되야 하는 횟수를 저장해서,
 * start위치에서 함수를 타고 들어가면서, 그 위치부터 출력해 나오기.
 * 스택 오버플로 날듯.
 * 
 * S를 배로 늘리면서, n을 반으로 계속 깍아 내릴 수 있음.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1055_끝이없음2 {
	static StringBuilder sb = new StringBuilder();
	static int st, ed;
	static String S = "";
	static ArrayList<Integer> lengths = new ArrayList<>();
	
	static String ref;
	static int reflen;
	static int loc = 0;
	static int limit = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//더해질 배열.
		ref = br.readLine();		
		S = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer ST = new StringTokenizer(br.readLine());
		st = Integer.parseInt(ST.nextToken());
		ed = Integer.parseInt(ST.nextToken())+1;
		
		// 압축 뭔가 이상함. 수정해야 함.
		// 연산 압축 코드
		while(ref.length() < 1000 && S.length() < 1000 && n > 1) {
			// S를 압축함.
			if(n % 2 == 0) { S = compression(S); n /= 2; }
			// ref를 하나 올림			
			else { ref = compression(ref); n--; }
		}
		// 연산 압축 완료

		System.out.println(ref);
		System.out.println(S);
		System.out.println(n);
		
		// S 안에 포함된 $의 수 세기.
		int refcount = 0;
		for(int i = 0; i < S.length(); i++) { if(S.charAt(i) == '$') refcount++; }
		reflen = ref.length();
		int Slen = S.length() - refcount;
		
		
		// 1번부터 n번까지 실행할 때, 문자열이 몇자리가 되는지 저장.
		lengths.add(reflen);
		for(int i = 1; i <= n; i++) {
			long tmp = lengths.get(i-1)*refcount + Slen;
			if(tmp >= ed) {
				lengths.add(ed+1);
				n = i;
				break;
			}			
			lengths.add((int)tmp);
		}
		//입력받기 끝.
		limit = lengths.get(n);
		
		printSystem(n);
//		System.out.println(ed + " " + limit + " " + st);
		int offset = (int) (ed - Math.max(limit, st));
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

				if(loc + lengths.get(n) >= st) {
					if(n != 1) {
						printSystem(n-1);
					}else {
						for(int j = 0; j < reflen; j++) {
							loc++;
							if(loc >= st && loc < ed) sb.append(ref.charAt(j));
//							System.out.println(loc + " " + sb);
						}
					}
				}else loc += lengths.get(n);
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
	
	static StringBuilder tmp = new StringBuilder();
	public static String compression(String str) {
		tmp.setLength(0);
		for(int i = 0; i < S.length(); i++) {
			char tmpchar = S.charAt(i);

			if(tmpchar == '$') { tmp.append(str); }
			else { tmp.append(tmpchar); }
		}
		return tmp.toString();
	}
}
/*
abc
$x$y$z$
10
30 50
bcyabcxabcyabczabczab
top
$coder
1
1 20
topcoder------------

a
$meric$
6
1 35
americamericamericamericamericameri


a
$v
10
0 90

a
$b
1
999 1030


a
$v
1000000000
1000000000 1000000099

thisisreferencestring1thisisreferencestring2thisi3
$9$8$7$6$5$4$3$2$1$9$8$7$6$5$4$3$2$1$9$8$7$6$5$4$3
1000000000
1000000000 1000000099

thisisreferencestring1thisisreferencestring2thisi3
$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
1000000000
1000000000 1000000099

thisisrefere
$$$$$$$$$$$$
1000000000
1000000000 1000000099

abc
$x$y$z$
1
10 20
bczabcabc-- ---

abc
$x$y$z$
3
30 70
bcyabcxabcyabczabczabcxabcyabczabc-------
bcyabcxabcyabczabczabcxabcyabczabcxabcxab


abc
$x$y$z
10
1 1


*/