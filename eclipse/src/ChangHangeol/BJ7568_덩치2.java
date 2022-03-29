package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 문제를 잘못 이해하고 품.
public class BJ7568_덩치2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] person = new int[n][3];
		Queue<Integer> idxs = new LinkedList<Integer>();
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int num = 1;
		while(num < n+1) {
			int[] maxp = new int[3];
			for(int i = 0; i < n; i++) {
				int[] p = person[i];
				// 이미 순위가 정해졌으면 계속 진행.
				if(p[2] != 0) continue;
				
				int hd = maxp[1] - p[1];
				int wd = maxp[0] - p[0];
				
				// 둘 다 크면
				if(hd < 0 && wd < 0) {
					maxp = p;
					idxs.clear();
					idxs.add(i);
					continue;
				}
				else if(hd > 0 && wd > 0) continue;
				// 비교 불가능한 상황
				else {
					idxs.add(i);
				}
			}
			
			count = 0;
			while(!idxs.isEmpty()) {
				int idx = idxs.poll();
				person[idx][2] = num;
				count++;
				//count에는 이번에 넣은 사람들 수가 저장됨.
			}
			num += count;
		}
	for(int[] p : person) System.out.print(p[2] + " ");
	}
}

/*
5
55 185
58 183
88 186
60 175
46 155

*/