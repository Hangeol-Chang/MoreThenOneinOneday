package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

목표 - 나 : 최대 수치
1 더하고 2곱하고, 이 값을 다시 1을 더하거나 2를 곱하거나 1을 빼는 함수로 재귀시킴.
 */

public class BJ1697 {
	static int goal = 0;
	static int maxcount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		maxcount = goal - num;
		
		int result = calc(num, 0);
		System.out.println(result);
	}
	
	public static int calc(int nownum, int count) {
		System.out.println("지금 수 : " + nownum + ", count : " + count);
		if(nownum == goal || count >= maxcount) return count;
		
		else if(nownum < goal) {
			return Math.min(calc(nownum+1, count+1), calc(nownum*2, count+1));
		}else {
			return calc(nownum-1, count+1);
		}
	}
}

/*
5 17
5 6 12 18 17

*/