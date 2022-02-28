package ChangHangeol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BJ2578 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//빙코판 입력받기
		int[][] bingo = new int[5][];
		for(int i = 0; i < 5; i++)
			bingo[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] judge = new int[12];
		boolean maked = false;
		int count = 0;
		int bincount = 0;
		//5줄 동안
		for(int t = 0; t < 5; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//5토큰 동안
			if(!maked) {
				for(int p = 0; p < 5; p++) {
					//하나 찾기
					int num = Integer.parseInt(st.nextToken());
					outer : for(int i = 0; i < 5; i++) {
						for(int j = 0; j < 5; j++) {
							if(num == bingo[i][j]) {
								if(++judge[i    ] == 5)          bincount++;
								if(++judge[j + 5] == 5)          bincount++;
								
								if(i == j   && ++judge[10] == 5) bincount++;
								if(i == 4-j && ++judge[11] == 5) bincount++;
								if(!maked) count++;
								if(bincount >= 3) maked = true;
								break outer;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}

/*
 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25

1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
1 7 13 19 25
5 9 17 21 16
11 6 2 3 4
12 23 14 8 18
22 24 10 15 20
*
*
*/