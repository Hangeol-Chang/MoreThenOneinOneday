package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 신맛은 곱, 쓴맛은 합.
// 신맛과 쓴맛의 차를 최소로
// 차이를 출력
public class BJ2961_도영이가만든맛있는음식 {
	static class node {
		int s, ss;
		node(int s, int ss){
			this.s = s; this.ss = ss;
		}
	}
	static int min = Integer.MAX_VALUE;
	static int N;
	static node[] data;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		data = new node[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			data[i] = new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 입력 끝.
		
		run(0, 1, 0);
		System.out.println(min);
	}
	public static void run(int idx, int s, int  ss) {
		if(idx > N) return;
		if(idx > 0) min = Math.min(min, Math.abs(s - ss));
		
		for(int i = idx; i < N; i++) {
			run(i+1, s * data[i].s, ss + data[i].ss );
		}
	}
}
