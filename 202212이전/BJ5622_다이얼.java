

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ini = br.readLine();
		
		int time = 0;
		for(int i = 0; i < ini.length(); i++) {
			int a = ini.charAt(i);
			
			if(a < 83) time += (a-56)/3;
			else if (a <= 89) time += (a-57)/3;
			else time += 10;
		}
		
		System.out.print(time);
	}
}
