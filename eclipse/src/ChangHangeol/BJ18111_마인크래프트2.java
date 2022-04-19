package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 모든 면의 높이를 똑같게 하는 작업이 필요.
 * i, j의 블럭을 제거하여 저장. 2초
 * 아무대나 놓을 수 있음. 1초
 */
public class BJ18111_마인크래프트2 {
	static int R, C, in, mincost, h;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		in = Integer.parseInt(st.nextToken());
		h = 0;
		
		int maxi = 0;
		int mini = 256;
		map = new int[257];
		// 0이 올릴 배열, 1이 깍을 배열.
		int[][] parsum = new int[2][257];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int idx = Integer.parseInt(st.nextToken());
				map[idx]++;
				maxi = Math.max(maxi, idx);
				mini = Math.min(mini, idx);
			}
		}
		mincost = Integer.MAX_VALUE;
		// 입력 완료
		
		// 부분합 적용.
		for(int i = mini+1; i <= maxi; i++)
			for(int j = mini; j < i; j++)
				parsum[0][i] += map[j]*(i-j);
		
		for(int i = maxi-1; i >= mini; i--)
			for(int j = maxi; j > i; j--)
				parsum[1][i] += map[j]*(j-i);
		// 부분합 완료

//		System.out.println(Arrays.toString(map));
//		System.out.println(Arrays.toString(parsum[0]));
//		System.out.println(Arrays.toString(parsum[1]));

		
		for(int i = mini; i <= maxi; i++) {
			// 내 아래있는건 다 더하고, 내 위에있는건 전부 깍고.
			if(parsum[0][i] <= in + parsum[1][i]) {
				int cost = parsum[1][i]*2 + parsum[0][i];
				if(cost <= mincost) {
					mincost = cost;
					h = i;
				}
			}
		}
		
		// 작업시간 + " " + 맞춰진 높이 출력.
		System.out.println(mincost + " " + h);
	}
}

/*

2 2 35
20 10
190 40

4 4 9999
1 2 3 4
2 3 4 3
3 4 3 2
4 3 2 1

3 4 99
0 0 0 0
0 0 0 0
0 0 0 1

1 3 68
0 0 1

3 4 11
29 51 54 44
22 44 32 62
25 38 16 2

4 4 36
15 43 61 21
19 33 31 55
48 63 1 30
31 28 3 8

1 1 0
0

2 2 0
256 256
0 0

7 7 6000
30 21 48 55 1 1 4
0 0 0 0 0 0 0
15 4 4 4 4 4 8
20 40 60 10 20 30 2
1 1 1 1 1 1 9
24 12 33 7 14 25 3
3 3 3 3 3 3 32
*/