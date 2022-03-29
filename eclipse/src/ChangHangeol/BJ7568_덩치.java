package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7568_덩치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] person = new int[n][3];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
			person[i][2] = 1;
		}
		// 입력받기 끝.
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
					person[i][2]++;
				}
			}
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