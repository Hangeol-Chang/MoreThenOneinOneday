package ChangHangeol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ref = br.readLine();
		
		for(int i = 97; i <= 122; i++) {
			char c = (char) i;
			System.out.print(ref.indexOf(Character.toString(c)) + " ");
		}
	}
}
