package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*

0 1 일 때 0, 2 3일 때 1 ... 10 11일 때 5

 */
public class 가희와함께하는코딩테스트_B번_가희와카오스파풀라투스 {
	static int[] time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			  time = Stream.of(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
		int[] heal = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int N = Integer.parseInt(br.readLine());
		// 명령 수행
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			String idf = st.nextToken();
			switch(idf) {
			case "^" :
				// 누르기
				heal[time[0]/2] = 0;
				break;
			default :
				int dh = 0;
				int dm = 0;
				switch(idf.charAt(idf.length()-1)) {
				case 'N' :
					dm = Integer.parseInt(idf.substring(0, 2));
					break;
				case 'R' :
					dh = Integer.parseInt(idf.substring(0, 1));
					break;
				}
				addtime(dh, dm);
				break;
			}
		}
		// 연산 끝.
		int result = 0;
		for(int h : heal) result += h;
		System.out.print( result >= 100 ? 100 : result);
	}
	public static void addtime(int h, int m) {
		time[1] += m;
		if(time[1] >= 60) {
			time[0]++;
			time[1] -= 60; 
		}
		time[0] = (time[0] + h)%12;
	}
}

/*

10:13
1 10 10 10 10 100
5
0.101 ^
2.333 2HOUR
4.444 ^
5.555 10MIN
6.666 ^

*/