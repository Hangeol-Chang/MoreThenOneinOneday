

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 언젠가 풉시당
public class SWEA4311_오래된스마트폰 {
	public static class data {
		int clickc;
		boolean eq;
		data(int clickc, boolean eq) {
			this.clickc = clickc;
			this.eq = eq;
		}
		int totclick() {
			return clickc + (eq ? 1 : 0);
		}
	}
	static String idfref = "_+-*/";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int N = Integer.parseInt(st.nextToken());
			int O = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] usenum = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			st = new StringTokenizer(br.readLine());
			ArrayList<Character> useidf = new ArrayList<>();
			for(int i = 0; i < O; i++) useidf.add(idfref.charAt(Integer.parseInt(st.nextToken())));
			
			int goal = Integer.parseInt(br.readLine());
			// 입력 완료
			
			data[] map = new data[1000];
			
			// 한자리 수들 다 넣기.
			Queue<Integer> que = new LinkedList<>();
			for(int num : usenum) {
				map[num] = new data(1, false);
				que.add(num);
			}
		
			while(!que.isEmpty()) {
				int now = que.poll();
				
				// 모든 수에 대해 모든 연산자에 대해 진행.
//				for()
				for(char idf : useidf) {
					
				}
				for(int num : usenum) {
					int newnum = now*10 + num;
					if(newnum > 999 || map[newnum] != null) continue;
				}
			}
			sb.append("#" + t + " " + (map[goal].totclick() <= M ? map[goal].totclick() : -1) + "\n");
		}
		System.out.println(sb);
	}
	public static int calc(int d1, int d2, char idf) {
		switch (idf) {
		case '+' : return d1 + d2;
		case '-' : return d1 - d2;
		case '*' : return d1 * d2;
		default :  return d1 / d2;
		}
	}
}
