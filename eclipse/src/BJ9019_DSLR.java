

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
계산기 레지스터
n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4

D : 2배(10000으로 나눈 나머지)
S : 1 빼기(0이라면 9999로)
L : 한칸 왼쪽으로 옮기기
R : 한칸 오른쪽으로 옮기기
 */
public class BJ9019_DSLR {
	public static char[] mods = {'D', 'S', 'L', 'R'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정답 저장할 배열
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int[] dist = new int[10000];
			String[] orders = new String[10000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int edd = Integer.parseInt(st.nextToken());
			dist[stt] = 1;
			orders[stt] = "";
			
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(stt);
			run : while(dist[edd] == 0) {
				// 위치를 가져옴.
				int loc = que.poll();
				
				for(char mod : mods) {
					int newloc = calc(loc, mod);
					if(dist[newloc] == 0) {
						dist[newloc] = dist[loc] + 1;
						orders[newloc] = orders[loc] + mod;
						
						if(newloc == edd) break run;
						que.add(newloc);
					}
				}
			}
			sb.append(orders[edd] + "\n");
		}
		System.out.print(sb);
	}
	// 필요 기능들
	public static int calc(int num, char mod) {
		switch(mod) {
		case 'D' : return num*2 % 10000;
		case 'S' : return (num+9999) % 10000;
		case 'L' : return (num%1000)*10 + num/1000;
		case 'R' : return (num%10)*1000 + num/10;
		}
		return 0;
	}
}
