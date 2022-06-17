

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 위아래로 가장 가까운 수를 찾아오기.
 * 앞자리부터 뒤지기
 * 
 * 채널 50만개짜리는 한달 요금이 얼마나 되나
 */
public class BJ1107_리모컨 {
	static int targetnum = 0;
	static int bit = 0;
	static int[] d = {1, -1};
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String numstr = br.readLine();
		int len = numstr.length();
		targetnum = Integer.parseInt(numstr);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		if(n > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) { bit += 1<<Integer.parseInt( st.nextToken()); }
		}
		
		count = Math.abs(targetnum - 100);
		count = Math.min(count, Math.min(check(targetnum, len, 0), check(targetnum, len, 1)));
		System.out.println(count);
	}
	public static int check(int num, int len, int j) {
		outer : while(true) {
			for(int i = 0; i < len; i++) {
//				System.out.println("현재 수 : " + num + ", 판정 중인 자리 : " + i);
				//i번째 자리 수를 가져옴.
				int tmp = (int)((num / Math.pow(10,  i)) % 10);	//이건 제대로 돔.
				int target = 1<<tmp;

				//통과하면 target버튼은 고장난거
				if((target & bit) == target) {
					// xxx000이나 xxx999로 만드는 코드					
					if(d[j] == 1) {
						num += d[j]*Math.pow(10, i);
						num -= num % Math.pow(10, i);
					}else {
						if(i >= 1) num -= ((num % Math.pow(10,  i-1)) + 1);
						else num -= 1;
						if(num < 0) { return count; }
					}
					if(count < Math.abs(num - targetnum) + len) break outer;
					len = Integer.toString(num).length();
//					System.out.println(num);
					continue outer;
				}
			}
			break;
		}
//		System.out.println("구해진 값 : " + (Math.abs(targetnum - num) + len));
		return Math.abs(num - targetnum) + len;
	}
}

/*
100000
9
0 1 2 3 4 5 6 7 8

1000
9
0 2 3 4 5 6 7 8 9

7 나와야 됨.

8
10
0 1 2 3 4 5 6 7 8 9
*/
