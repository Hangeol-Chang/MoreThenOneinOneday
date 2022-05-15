package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1075_나누기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		N = N/100 * 100;
		int quo = N / F;
		
		if(N % F == 0) {
			System.out.println("00");
		}else {
			System.out.printf("%02d", (quo+1)*F - N);
		}
	}
}
