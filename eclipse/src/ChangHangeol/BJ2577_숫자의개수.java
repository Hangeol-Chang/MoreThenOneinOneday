package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2577_숫자의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int num = a*b*c;
		int[] arr = new int[10];
		while(num > 0) {
			int idf = num%10;
			arr[idf]++;
			num /= 10;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
