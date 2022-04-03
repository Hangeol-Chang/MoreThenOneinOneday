package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ9663_N_Queen2 {
	static int N, count;
	static int[] loc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Byte.parseByte(br.readLine());
		br.close();
		
		loc = new int[N];
		queen((byte)0);
		
		System.out.println(count);
	}
	private static void queen(byte num) {
		if(num == N) {
			count++;
			return;
		}
		// num번째 줄에 놓을 수 있는 위치를 판단함.
		// num, c의 위치에 놓고 내려갈거임
		outer : for(int c = 0; c < N; c++) {
			boolean can = true;
			
			// d번째 줄의 말과 겹치는지 확인
			for(int d = 0; d < num; d++) {
				if(loc[d] == c || Math.abs(d - num) == Math.abs(c - loc[d])) {
					can = false; 
					continue outer;
				}
			}
			
			if(can) {
				loc[num] = c;
				queen((byte)(num+1));
			}
		}
	}
}
