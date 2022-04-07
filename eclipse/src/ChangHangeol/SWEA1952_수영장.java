package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA1952_수영장 {
	// 각 이용권별로 차감할 수.
	static int[][] boom = { {31},
							{31},
							{31,31,31},
							{31,31,31,31,31,31,31,31,31,31,31,31}};
	// 금액 배열
	static int[] d;
	static int[] months;
	static int minv;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			d = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 몇개월이나 다닐거냐
			int count = 0;
			months = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
				if(months[i] != 0) count++;
			}
			// 입력받기 끝.
			
			// 연간 끊는게 최대.
			minv = d[3];
			run(count, 0);
			
			sb.append("#" + t + " " + minv + "\n");
		}
		System.out.println(sb);
	}
	public static void run(int count, int sum) {
		if(sum >= minv) return;
		if(count <= 0) {
//			System.out.println("통과 : " + minv + " " + sum);
			minv = Math.min(sum, minv);
			return;
		}
		
		for(int i = 0; i < 12; i++) {
			if(months[i] <= 0) continue;
			// 이용권에 해당하는 만큼 빼주기
			for(int de = 0; de < 4; de++) {
				// 깍기
				int tmp = 1;
				if(de == 0) tmp = months[i];
				int tmpcount = cutting(de, i, -1);
				
//				for(int p = 0; p < 12; p++) {
//					System.out.print(months[p] + " ");
//				}
//				System.out.println();
				
				run(count - tmpcount, sum + d[de]*tmp);
				
				//되돌려놓기.
				cutting(de, i, 1);
			}
			return;
		}
	}
	public static int cutting(int de, int i, int idf) {
		int tmpcount = 0;
		for(int cut : boom[de]) {
			months[i] += idf*cut;
			if(months[i] <= 0 && months[i] > -31) tmpcount++;
			i++;
			if(i >= 12) break;
		}
		return tmpcount;
	}
}
/*

1
10 40 100 300   
0 0 2 9 1 5 0 0 0 0 0 0

1
10 130 360 1200
0 0 0 15 14 11 15 13 12 15 10 15

7
2000 1000 30 2000
31 0 0 31 0 0 31 0 0 3 1 0
10 10 10 10
0 0 0 0 0 0 0 0 0 0 0 0
10 1000 1000 2000
1 1 1 1 1 1 1 1 1 1 1 1
2000 1000 100 10
0 1 0 0 0 0 0 0 0 0 0 0
10 10 40 1000
30 28 30 30 30 30 30 30 30 30 30 30
10 10 29 1000
30 28 30 30 30 30 30 30 30 30 30 30
10 900 2000 8000
30 28 30 30 30 30 30 30 30 30 1 30

*/